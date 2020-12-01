package cards

class CardDeck(private val cards: MutableList<Card> = ArrayList()) {
    init {
        for (suit in Suit.all) {
            for (rank in Rank.all) {
                val card = Card(rank, suit);
                cards.add(card)
            }
        }
    }

    fun draw(): Card? {
        if (cards.isEmpty()) {
            return null
        }

        return cards.removeAt(getRandomIndex(cards.size))
    }

    private fun getRandomIndex(size: Int): Int {
        return (0 until size).random()
    }
}