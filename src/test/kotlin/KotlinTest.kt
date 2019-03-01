import com.google.gson.Gson
import com.phenix.main
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun testMain() {
        val args: Array<String> = emptyArray()
        main(args)
    }

    @Test
    fun printString() {
        val person = Person("John", 31)
        print(person)
    }

    @Test
    fun testChainMethod() {
        listOf("java", "swift", "javascript", "oc")
                .asSequence()
                .sorted()
                .map { it -> it.plus(2) }
                .filter { it -> it.length > 4 }
                .count()
    }

    @Test
    fun testAnonymousInnerClass() {
        val programmer: Human = object : Human {
            override fun think() {
                print("I'm a programmer.")
            }
        }

        programmer.think()
    }

    @Test
    fun testInnerClass() {
        val outer = Outer().Nested().foo()
        println(outer)
    }

    @Test
    fun `Empty list does not change at all`() {
        val emptyList = emptyList<Int>()
        assertEquals(emptyList, emptyList.quickSort())
        assertSame(emptyList, emptyList.quickSort())
    }
}

class Outer {
    private val welcomeMessage: String = "Welcome to the TutorialPoints.com."

    inner class Nested {
        fun foo(): String = welcomeMessage
    }
}

interface Human {
    fun think()
}

data class Person(var name: String, var age: Int) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}


fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size < 2) return this
    val pivot = this.first()
    val (smaller, bigger) = drop(1).partition { it < pivot }
    return smaller.quickSort() + pivot + bigger.quickSort()
}