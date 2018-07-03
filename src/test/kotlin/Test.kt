import com.google.gson.Gson
import org.junit.Test
import java.util.stream.Collector
import kotlin.concurrent.timer

class Test {
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

}

data class Person(var name: String, var age: Int) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}


fun main(args: Array<String>) {
    listOf("java", "swift", "javascript", "oc")
            .asSequence()
            .sorted()
            .map { it -> it.plus(2) }
            .filter { it -> it.length > 4 }
            .count()
}