package cards

class Card(val rank: Rank, val suit: Suit) {
    override fun toString(): String {
        return "Card(rank=${rank.value}, suit=${suit.value})"
    }
}