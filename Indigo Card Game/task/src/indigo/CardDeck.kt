package indigo

enum class CardDeck(val rank: String, val suit: String, private val abbreviated: String,
                    private val icon: String, val pointValue: Int = 0) {
    KING_CLUB("King","Club", "K", "♣", 1),
    KING_DIAMOND("King","Diamond", "K", "♦", 1),
    KING_HEART("King","Heart", "K", "♥", 1),
    KING_SPADE("King","Spade", "K", "♠", 1),
    QUEEN_CLUB("Queen","Club", "Q", "♣", 1),
    QUEEN_DIAMOND("Queen","Diamond", "Q", "♦", 1),
    QUEEN_HEART("Queen","Heart", "Q", "♥", 1),
    QUEEN_SPADE("Queen","Spade", "Q", "♠", 1),
    JACK_CLUB("Jack","Club", "J", "♣", 1),
    JACK_DIAMOND("Jack","Diamond", "J", "♦", 1),
    JACK_HEART("Jack","Heart", "J", "♥", 1),
    JACK_SPADE("Jack","Spade", "J", "♠", 1),
    TEN_CLUB("Ten","Club", "10", "♣", 1),
    TEN_DIAMOND("Ten","Diamond", "10", "♦", 1),
    TEN_HEART("Ten","Heart", "10", "♥", 1),
    TEN_SPADE("Ten","Spade", "10", "♠", 1),
    NINE_CLUB("Nine","Club", "9", "♣"),
    NINE_DIAMOND("Nine","Diamond", "9", "♦"),
    NINE_HEART("Nine","Heart", "9", "♥"),
    NINE_SPADE("Nine","Spade", "9", "♠"),
    EIGHT_CLUB("Eight","Club", "8", "♣"),
    EIGHT_DIAMOND("Eight","Diamond", "8", "♦"),
    EIGHT_HEART("Eight","Heart", "8", "♥"),
    EIGHT_SPADE("Eight","Spade", "8", "♠"),
    SEVEN_CLUB("Seven","Club", "7", "♣"),
    SEVEN_DIAMOND("Seven","Diamond", "7", "♦"),
    SEVEN_HEART("Seven","Heart", "7", "♥"),
    SEVEN_SPADE("Seven","Spade", "7", "♠"),
    SIX_CLUB("Six","Club", "6", "♣"),
    SIX_DIAMOND("Six","Diamond", "6", "♦"),
    SIX_HEART("Six","Heart", "6", "♥"),
    SIX_SPADE("Six","Spade", "6", "♠"),
    FIVE_CLUB("Five","Club", "5", "♣"),
    FIVE_DIAMOND("Five","Diamond", "5", "♦"),
    FIVE_HEART("Five","Heart", "5", "♥"),
    FIVE_SPADE("Five","Spade", "5", "♠"),
    FOUR_CLUB("Four","Club", "4", "♣"),
    FOUR_DIAMOND("Four","Diamond", "4", "♦"),
    FOUR_HEART("Four","Heart", "4", "♥"),
    FOUR_SPADE("Four","Spade", "4", "♠"),
    THREE_CLUB("Three","Club", "3", "♣"),
    THREE_DIAMOND("Three","Diamond", "3", "♦"),
    THREE_HEART("Three","Heart", "3", "♥"),
    THREE_SPADE("Three","Spade", "3", "♠"),
    TWO_CLUB("Two","Club", "2", "♣"),
    TWO_DIAMOND("Two","Diamond", "2", "♦"),
    TWO_HEART("Two","Heart", "2", "♥"),
    TWO_SPADE("Two","Spade", "2", "♠"),
    ACE_CLUB("Ace","Club", "A", "♣", 1),
    ACE_DIAMOND("Ace","Diamond", "A", "♦", 1),
    ACE_HEART("Ace","Heart", "A", "♥", 1),
    ACE_SPADE("Ace","Spade", "A", "♠", 1);

    override fun toString(): String {
        return "$abbreviated$icon"
    }

    companion object {
        fun newDeck(): MutableList<CardDeck> {
            val deck = mutableListOf<CardDeck>()
            for (template in values()) {
                deck.add(template)
            }
            return deck
        }

    }
}