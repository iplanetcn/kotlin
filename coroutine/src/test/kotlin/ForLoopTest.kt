
import org.junit.jupiter.api.Test

/**
 * ForLoopTest
 *
 * @author john
 * @since 2022-02-28
 */
class ForLoopTest {
    @Test
    internal fun testForLoop() {
        for (i in 0..24 step 4) {
            print("$i ")
        }
    }
}