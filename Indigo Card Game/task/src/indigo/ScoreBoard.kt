package indigo

object ScoreBoard {
    var playerScore = 0
    var computerScore = 0
    var firstToPlayIsPlayer = false
    var isGameOver = false

    fun tabulateScore(playerCardPile: MutableList<CardDeck>, computerCardPile: MutableList<CardDeck>) {
        playerScore = if (isGameOver && playerCardPile.size > computerCardPile.size ||
            isGameOver && playerCardPile.size == computerCardPile.size && firstToPlayIsPlayer) {
            playerCardPile.sumOf { it.pointValue } + 3
        } else {
            playerCardPile.sumOf { it.pointValue }
        }
        computerScore = if (isGameOver && computerCardPile.size > playerCardPile.size ||
            isGameOver && computerCardPile.size == playerCardPile.size && !firstToPlayIsPlayer) {
            computerCardPile.sumOf { it.pointValue } + 3
        } else {
            computerCardPile.sumOf { it.pointValue }
        }
    }

    fun score(player: Player, computer: Computer) {
        println("Score: ${player.name} $playerScore - ${computer.name} $computerScore")
        println("Cards: ${player.name} ${player.cardPile.size} - ${computer.name} ${computer.cardPile.size}")
    }
}