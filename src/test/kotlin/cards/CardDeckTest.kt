package cards

import org.junit.jupiter.api.Test

/**
 * CardDeckTest
 *
 * @author john
 * @since 2021-08-06
 */
class CardDeckTest {
    private val cardDeck = CardDeck()

    @Test
    fun test_CardDeck() {
        cardDeck.shuffle()
        while (true) {
            cardDeck.draw()?.let { println(it) } ?: break
        }
    }
}