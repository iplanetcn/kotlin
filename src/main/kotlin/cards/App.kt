package cards

fun main() {
    val cardDeck = CardDeck()
    while (true) {
        val card = cardDeck.draw()
        if (card == null) {
            break
        } else {
            println("${card.rank}:${card.suit}")
        }
    }
}