package graph

import kotlin.math.abs

/**
 * AStarSearch
 *
 * @author john
 * @since 2021-12-22
 */
typealias GridPosition = Pair<Int, Int>
typealias Barrier = Set<GridPosition>

const val MAX_SCORE = 99999999

abstract class Grid(private val barriers: List<Barrier>) {
    open fun heuristicDistance(start: GridPosition, end: GridPosition): Int {
        val dx = abs(start.first - end.first)
        val dy = abs(start.second - end.second)
        return (dx + dy) + (-2) * minOf(dx, dy)
    }

    private fun inBarrier(position: GridPosition) = barriers.any { it.contains(position) }

    abstract fun getNeighbours(position: GridPosition): List<GridPosition>

    open fun moveCost(from: GridPosition, to: GridPosition) = if (inBarrier(to)) MAX_SCORE else 1
}

class SquareGrid(width: Int, height: Int, barriers: List<Barrier>) : Grid(barriers) {
    private val heightRange: IntRange = 0 until height
    private val widthRange: IntRange = 0 until width

    private val validMoves =
        listOf(Pair(1, 0), Pair(-1, 0), Pair(0, -1), Pair(0, 1), Pair(1, 1), Pair(1, -1), Pair(-1, 1), Pair(-1, -1))

    override fun getNeighbours(position: GridPosition) = validMoves
        .map { GridPosition(position.first + it.first, position.second + it.second) }
        .filter { inGrid(it) }

    private fun inGrid(it: GridPosition) = (it.first in widthRange) && (it.second in heightRange)
}

fun aStarSearch(start: GridPosition, end: GridPosition, grid: Grid): Pair<List<GridPosition>, Int> {
    fun generatePath(currentPos: GridPosition, cameFrom: Map<GridPosition,GridPosition>): List<GridPosition> {
        val path = mutableListOf(currentPos)
        var current = currentPos
        while (cameFrom.containsKey(current)){
            current = cameFrom.getValue(current)
            path.add(0, current)
        }
        return path.toList()
    }

    val openVertices = mutableSetOf(start)
    val closedVertices = mutableSetOf<GridPosition>()
    val costFromStart = mutableMapOf(start to 0)
    val estimatedTotalCost = mutableMapOf(start to grid.heuristicDistance(start, end))

    val cameFrom = mutableMapOf<GridPosition, GridPosition>()

    while (openVertices.size > 0) {
        val currentPos = openVertices.minByOrNull { estimatedTotalCost.getValue(it) }
        currentPos?.let {
            if (it == end) {
                val path = generatePath(it, cameFrom)
                return Pair(path, estimatedTotalCost.getValue(end))
            }

            openVertices.remove(it)
            closedVertices.add(it)

            grid.getNeighbours(currentPos)
                .filterNot { closedVertices.contains(it) }
                .forEach { neighbour ->
                    val score = costFromStart.getValue(currentPos) + grid.moveCost(currentPos, neighbour)
                    if (score < costFromStart.getOrDefault(neighbour, MAX_SCORE)) {
                        if (!openVertices.contains(neighbour)) {
                            openVertices.add(neighbour)
                        }
                        cameFrom[neighbour] = currentPos
                        costFromStart[neighbour] = score
                        estimatedTotalCost[neighbour] = score + grid.heuristicDistance(neighbour, end)
                    }
                }

        }
    }

    throw IllegalArgumentException("No path from start $start to end $end")
}

fun main(args: Array<String>) {

    val barriers = listOf(setOf(Pair(2,4), Pair(2,5), Pair(2,6), Pair(3,6), Pair(4,6), Pair(5,6), Pair(5,5),
        Pair(5,4), Pair(5,3), Pair(5,2), Pair(4,2), Pair(3,2)))

    val (path, cost) = aStarSearch(GridPosition(0,0), GridPosition(7,7), SquareGrid(8,8, barriers))

    println("Cost: $cost  Path: $path")
    for(x in 0 until 8) {
        for (y in 0 until 8) {
            if (barriers.any { it.contains(Pair(x,y)) }) {
                print("█")
            } else if (path.contains(Pair(x,y))) {
                print("*")
            } else {
                print("-")
            }
        }
        println()
    }
}