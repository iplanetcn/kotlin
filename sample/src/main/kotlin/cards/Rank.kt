package cards

enum class Suit(val value: String) {
    SPADES("♠️"), HEARTS("♥️"), CLUBS("♣️"), DIAMONDS("♦️");

    override fun toString(): String {
        return value
    }

    companion object {
        var all = arrayOf(SPADES, HEARTS, CLUBS, DIAMONDS)
    }

}