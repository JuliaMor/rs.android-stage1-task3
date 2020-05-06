package subtask4

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number <= 0) {
            return null
        }
        val first = number - 1
        var remainder = number * number - first * first
        val maxList = mutableListOf<Int>()
        val listSq = mutableListOf<Int>()
        while (remainder != 0) {
            val sqrt = kotlin.math.sqrt(remainder.toDouble()).toInt()
            remainder -= sqrt * sqrt
            maxList.add(sqrt)
        }
        val s = getList(maxList, number * number - first * first) ?: return null
        listSq.addAll(s)
        listSq.add(first)
        return listSq.sorted().toTypedArray()
    }

    private fun getList(list: List<Int>, sum: Int): List<Int>? {
        for (item in list) {
            for (i in 1..item) {
                val mutableList = mutableListOf(i)
                var remainder = sum - i * i
                while (remainder != 0) {
                    val sqrt = kotlin.math.sqrt(remainder.toDouble()).toInt()
                    remainder -= sqrt * sqrt
                    mutableList.add(sqrt)
                }
                if (mutableList.distinct().size == mutableList.size) {
                    return mutableList
                }
            }
        }
        return null
    }
}
