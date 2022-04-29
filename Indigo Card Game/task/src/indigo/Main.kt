package indigo

fun main() {
    val player = Player()
    val computer = Computer()
    var emptyDealerDeck = false
    var playerLastWinner: Boolean? = null
    println("Indigo Card Game")
    Dealer.whoIsFirstToGo()
    Dealer.gameStart()
    Dealer.dealCards(player.cardHand, computer.cardHand)
    start@while (true) {
        println()
        if (Table.tableCards.size > 0) {
            println("${Table.tableCards.size} cards on the table, and the top card is ${Table.tableCards.last()}")
        } else {
            println("No cards on the table")
        }
        if (player.cardHand.isEmpty() && computer.cardHand.isEmpty() && emptyDealerDeck) {
            ScoreBoard.isGameOver = true
            break@start
        }
        if (!Dealer.playerTurn) {
            Dealer.playerTurn = true
            if (computer.cardHand.isEmpty()) continue
            val computerCard = computer.computerSelectCard()
            println(computer.toString())
            println("Computer plays $computerCard")
            computer.cardHand.remove(computerCard)
            if (Table.tableCards.isNotEmpty() && computerCard.rank == Table.tableCards.last().rank ||
                Table.tableCards.isNotEmpty() && computerCard.suit == Table.tableCards.last().suit) {
                Table.tableCards.add(computerCard)
                computer.cardPile.addAll(Table.tableCards)
                Table.tableCards.clear()
                ScoreBoard.tabulateScore(player.cardPile, computer.cardPile)
                println("${computer.name} wins cards")
                playerLastWinner = false
                ScoreBoard.score(player, computer)
            } else {
                Table.tableCards.add(computerCard)
            }
        } else {
            Dealer.playerTurn = false
            if (player.cardHand.isEmpty()) continue
            print("Cards in hand:")
            for (card in 1..player.cardHand.size) {
                print(" $card)${player.cardHand[card - 1]}")
            }
            println()
            while(true) {
                println("Choose a card to play (1-${player.cardHand.size}):")
                val input = readLine()!!
                when {
                    input == "exit" -> {
                        println("Game Over")
                        break@start
                    }
                    input.toIntOrNull() in 1..player.cardHand.size -> {
                        if (Table.tableCards.isNotEmpty() && player.cardHand[input.toInt() - 1].rank == Table.tableCards.last().rank ||
                            Table.tableCards.isNotEmpty() && player.cardHand[input.toInt() - 1].suit == Table.tableCards.last().suit) {
                            Table.tableCards.add(player.cardHand[input.toInt() - 1])
                            player.cardPile.addAll(Table.tableCards)
                            ScoreBoard.tabulateScore(player.cardPile, computer.cardPile)
                            Table.tableCards.clear()
                            println("${player.name} wins cards")
                            playerLastWinner = true
                            ScoreBoard.score(player, computer)
                        } else {
                            Table.tableCards.add(player.cardHand[input.toInt() - 1])
                        }
                        player.cardHand.removeAt(input.toInt() - 1)
                        break
                    }
                    else -> continue
                }
            }

        }

        if (player.cardHand.isEmpty() && computer.cardHand.isEmpty()) {
            emptyDealerDeck = Dealer.dealCards(player.cardHand, computer.cardHand)
        }
    }
    when (playerLastWinner) {
        true -> player.cardPile.addAll(Table.tableCards)
        false -> computer.cardPile.addAll(Table.tableCards)
        else -> if (ScoreBoard.firstToPlayIsPlayer) {
            player.cardPile.addAll(Table.tableCards)
        } else{
            computer.cardPile.addAll(Table.tableCards)
        }
    }

    ScoreBoard.tabulateScore(player.cardPile, computer.cardPile)
    ScoreBoard.score(player, computer)
    println("Game Over")

}
