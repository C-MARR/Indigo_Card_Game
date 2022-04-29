package indigo

class Computer(val name: String = "Computer", val cardHand: MutableList<CardDeck> = mutableListOf(),
               val cardPile: MutableList<CardDeck> = mutableListOf()) {
    override fun toString(): String {
        return cardHand.joinToString(" ")
    }

    fun computerSelectCard(): CardDeck {
        var suitCandidates = listOf<CardDeck>()
        var rankCandidates = listOf<CardDeck>()
        var candidates = listOf<CardDeck>()
        val multipleSuits = cardHand.groupBy { it.suit }.filterValues { it.size > 1 }.values.flatten()
        val multipleRanks = cardHand.groupBy { it.rank }.filterValues { it.size > 1 }.values.flatten()

        if (Table.tableCards.isNotEmpty()) {
            suitCandidates = cardHand.filter { it.suit == Table.tableCards.last().suit }
            rankCandidates = cardHand.filter { it.rank == Table.tableCards.last().rank }
            candidates = suitCandidates + rankCandidates
        }
        return when {
            cardHand.size == 1 -> cardHand[0]
            candidates.size == 1 -> candidates[0]
            Table.tableCards.isEmpty() && multipleSuits.isNotEmpty() -> multipleSuits.random()
            Table.tableCards.isEmpty() && multipleRanks.isNotEmpty() -> multipleRanks.random()
            Table.tableCards.isEmpty() -> cardHand.random()
            candidates.isEmpty() && multipleSuits.isNotEmpty() -> multipleSuits.random()
            candidates.isEmpty() && multipleRanks.isNotEmpty() -> multipleRanks.random()
            candidates.isEmpty() -> cardHand.random()
            suitCandidates.size > 1 -> suitCandidates.random()
            rankCandidates.size > 1 -> rankCandidates.random()
            candidates.size > 1 -> candidates.random()
            else -> cardHand.random()
        }
    }
}