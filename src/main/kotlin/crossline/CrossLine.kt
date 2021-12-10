package crossline

import java.awt.geom.Line2D
import java.awt.geom.Point2D


/**
 * CrossLine
 *
 * @author john
 * @since 2021-11-23
 */

fun main() {
    val line1 = Line2D.Float(Point2D.Float(0f,0f), Point2D.Float(2f,2f))
    val line2 = Line2D.Float(Point2D.Float(2f,2f), Point2D.Float(2f,0f))

    println(line1.intersectsLine(line2))
}


