package indigo

object Dealer {
    var playerTurn = true
    private var dealerDeck = shuffleDeck(CardDeck.newDeck())

    fun whoIsFirstToGo() {
        while (true) {
            println("Play First?")
            return when (readLine()!!.lowercase()) {
                "yes" -> {
                    playerTurn = true
                    ScoreBoard.firstToPlayIsPlayer = true
                }
                "no" -> {
                    playerTurn = false
                    ScoreBoard.firstToPlayIsPlayer = false
                }
                else -> continue
            }
        }
    }

    fun gameStart(deck: MutableList<CardDeck> = dealerDeck) {
        print("Initial cards on the table: ")
        for (card in 0..3) {
            Table.tableCards.add(deck[card])
            print("${Table.tableCards[card]} ")
            deck.removeAt(card)
        }
        println()
    }


    private fun shuffleDeck(deck: MutableList<CardDeck>) = deck.shuffled().toMutableList()

    fun dealCards(playerCardHand: MutableList<CardDeck>,
                  computerCardHand: MutableList<CardDeck>, deck: MutableList<CardDeck> = dealerDeck): Boolean {
        for (card in 1..12) {
            if (deck.size == 0) {
                break
            } else if (playerTurn) {
                playerCardHand.add(deck[0])
                playerTurn = !playerTurn
                deck.removeAt(0)
            } else {
                computerCardHand.add(deck[0])
                deck.removeAt(0)
                playerTurn = !playerTurn
            }
        }
        return deck.isEmpty()
    }
}