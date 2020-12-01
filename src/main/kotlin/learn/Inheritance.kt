package learn

open class Shape {
    open val vertexCount: Int = 0
    open fun draw() {

    }

    fun fill() {

    }
}

class Circle : Shape() {
    override val vertexCount: Int = 4
    override fun draw() {
        super.draw()
    }
}

interface IShape {
    val vertexCount: Int
}

open class Rectangle(override val vertexCount: Int = 4) : Shape(), IShape {
    override fun draw() {
        super.draw()
        println("Drawing a rectangle")
    }
}

class FilledRectangle(vertexCount: Int) : Rectangle(vertexCount) {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }
}

/**
 * （backing property）：幕后属性
 */

class Polygon : IShape {
    override var vertexCount: Int = 0
    val isEmpty: Boolean
        get() = this.vertexCount == 0
    // field 标识符只能⽤在属性的访问器内。
    var counter = 0
        set(value) {
            if (value >= 0) field = value
        }
}

