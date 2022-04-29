package indigo

open class Player(val name: String = "Player", val cardHand: MutableList<CardDeck> = mutableListOf(),
                  val cardPile: MutableList<CardDeck> = mutableListOf()) {
    override fun toString(): String {
        return cardHand.joinToString(" ")
    }
}