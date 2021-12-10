package io2018._08_local_sealed_casts

fun main() {
    val root = Container(
            Text("a"),
            Container(
                    Text("b"),
                    Container(
                            Text("c"),
                            Text("d")
                    ),
                    Text("e")
            ),
            Text("f")
    )

    println(root.extractText())
}

sealed class Element
class Container(vararg val children: Element) : Element()
class Text(val text: String) : Element()

fun Element.extractText(): String {
    val sb = StringBuilder()
    fun extractText(e: Element) {
        when (e) {
            is Text -> sb.append(e.text)
            is Container -> e.children.forEach(::extractText)
        }
    }

    extractText(this)

    return sb.toString()
}

