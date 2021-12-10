package cards

class CardDeck(
    private val cards: MutableList<Card> = ArrayList()
) {
    init {
        for (suit in Suit.all) {
            for (rank in Rank.all) {
                val card = Card(rank, suit)
                cards.add(card)
            }
        }
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun draw(): Card? {
        if (cards.isEmpty()) {
            return null
        }

        return cards.removeFirst()
    }
}