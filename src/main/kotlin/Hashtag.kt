class Hashtag {
    private  var hashtag = Array(3) { Array(3) { " " } }

    init {
        hashtagZero()
    }

    fun hashtagZero(){
        for(i in hashtag.indices){
            for(j in hashtag.indices){
                hashtag[i][j] = " "
            }
        }
        displayHashtag()
    }

    fun displayHashtag() {
        println()
        for (i in hashtag.indices) {
            for (j in hashtag.indices) {
                when (hashtag[i][j]) {
                    " " -> print("   ")
                    "X" -> print(" X ")
                    "O" -> print(" O ")
                }
                if (j < hashtag.size - 1) {
                    print("|")
                }
            }
            println()
        }
    }

    fun checkRows(): String {
        for (i in hashtag.indices) {
            if ((hashtag[i][0] + hashtag[i][1] + hashtag[i][2]) == "XXX") {
                return "X"
            }
            if ((hashtag[i][0] + hashtag[i][1] + hashtag[i][2]) == "OOO") {
                return "O"
            }
        }
        return " "
    }

    fun checkColumns(): String {
        for (i in hashtag.indices) {
            if ((hashtag[0][i] + hashtag[1][i] + hashtag[2][i]) == "XXX") {
                return "X"
            }
            if ((hashtag[0][i] + hashtag[1][i] + hashtag[2][i]) == "OOO") {
                return "O"
            }
        }
        return " "
    }

    fun checkDiagonals(): String {
        if ((hashtag[0][0] + hashtag[1][1] + hashtag[2][2]) == "XXX") {
            return "X"
        }
        if ((hashtag[0][0] + hashtag[1][1] + hashtag[2][2]) == "OOO") {
            return "O"
        }
        if ((hashtag[0][2] + hashtag[1][1] + hashtag[2][0]) == "XXX") {
            return "X"
        }
        if ((hashtag[0][2] + hashtag[1][1] + hashtag[2][0]) == "OOO") {
            return "O"
        }
        return " "
    }

    fun setHashtag(row: Int, column: Int, player: String) {
        if (hashtag[row][column] == " ") {
            hashtag[row][column] = player
        }
    }

   fun isCellEmpty(row: Int, column: Int): Boolean {
        return hashtag[row][column] == " "
   }
}