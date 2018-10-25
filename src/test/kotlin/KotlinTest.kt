import com.google.gson.Gson
import com.phenix.main
import org.junit.Test

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