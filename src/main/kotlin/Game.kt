import java.util.Scanner

class Game {
    private val hashtag: Hashtag = Hashtag()
    private var rounds = 1
    private var turn = 1

    private val scanner = Scanner(System.`in`)

    fun play() {
        while (rounds <= 9) {
            val currentPlayer = if (turn % 2 == 0) "O" else "X"
            println("Vez do jogador $currentPlayer")

            var row: Int
            var column: Int

            while (true) {
                println("Digite a linha (0, 1, ou 2): ")
                row = scanner.nextInt()
                println("Digite a coluna (0, 1, ou 2): ")
                column = scanner.nextInt()

                if (isValidMove(row, column)) {
                    break
                } else {
                    println("Movimento inválido. Tente novamente.")
                }
            }

            hashtag.setHashtag(row, column, currentPlayer)
            hashtag.displayHashtag()

            if (checkWinner(currentPlayer)) {
                println("Jogador $currentPlayer venceu!")
                break
            }

            rounds++
            turn++
        }

        if (rounds == 10) {
            println("Deu velha!")
        }
    }

    private fun isValidMove(row: Int, column: Int): Boolean {
        return row in 0..2 && column in 0..2 && hashtag.isCellEmpty(row, column)
    }

    private fun checkWinner(player: String): Boolean {
        return hashtag.checkRows() == player || hashtag.checkColumns() == player || hashtag.checkDiagonals() == player
    }
}