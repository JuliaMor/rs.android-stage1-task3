package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val combinations = array[0]
        val num = array[1]
        for (i in 1 until num) {
            if (factorial(i) * factorial(num - i) == factorial(num) / combinations)
                return i
        }
        return null
    }

    private fun factorial(num: Int): Long {
        var result = 1L
        for (i in 2..num) result *= i
        return result
    }
}
