package cards

enum class Suit(val value: String) {
    ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN(
        "10"
    ),
    JACK("J"), QUEEN("Q"), KING("K");

    override fun toString(): String {
        return value
    }

    companion object {
        var all = arrayOf(
            ACE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            SIX,
            SEVEN,
            EIGHT,
            NINE,
            TEN,
            JACK,
            QUEEN,
            KING
        )
    }

}