package cards

class Card(
    private val rank: Rank,
    private val suit: Suit
) {
    override fun toString(): String {
        return "Card(rank=${rank.value}, suit=${suit.value})"
    }
}