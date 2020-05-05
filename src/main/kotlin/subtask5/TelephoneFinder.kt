package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains("-")) {
            return null
        }
        val arrResult = arrayOf<String>().toMutableList()
        val arr = number.toCharArray().toMutableList()
        var index = 0
        for (digit in arr) {
            val arrString = ArrayList<String>()
            for (test in arr) {
                arrString.add(test.toString())
            }
            val arrNeighbour = getNeighbours(digit)
            for (nb in arrNeighbour) {
                arrString.removeAt(index)
                arrString.add(index, nb.toString())
                arrResult.add(arrToString(arrString))
            }
            index++
        }
        return arrResult.toTypedArray()
    }

    private fun arrToString(arrString: ArrayList<String>): String {
        val sb = StringBuilder()
        for (s in arrString) {
            sb.append(s)
        }
        return sb.toString()
    }

    private fun getNeighbours(i: Char) = when (i) {
        '1' -> arrayOf(2, 4)
        '2' -> arrayOf(1, 3)
        '3' -> arrayOf(2, 6)
        '4' -> arrayOf(1, 5, 7)
        '5' -> arrayOf(2, 4, 6, 8)
        '6' -> arrayOf(3, 5, 9)
        '7' -> arrayOf(4, 8)
        '8' -> arrayOf(5, 7, 9, 0)
        '9' -> arrayOf(6, 8)
        '0' -> arrayOf(8)
        else -> arrayOf()
    }

}
