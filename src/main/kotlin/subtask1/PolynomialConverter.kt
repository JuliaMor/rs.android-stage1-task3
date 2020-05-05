package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        val x = "x"
        val degree = "^"
        if(numbers.isEmpty())
            return null
        val sb = StringBuilder()
        var count = numbers.size - 1
        for (number in numbers) {
            if (number != 0) {
                if (sb.isNotEmpty())
                    sb.append(addSign(number))
                when (count) {

                    0 -> sb.append(number)
                    1 -> {
                        if (number == 1 || number == -1) {
                            sb.append(x)
                        } else {
                            sb.append(number).append(x)
                        }

                    }
                    else -> {
                        sb.append(number.absoluteValue).append(x).append(degree).append(count)
                    }
                }
            }
            count--
        }
        return sb.toString()
    }

    private fun addSign(number: Int) = if (number > 0) {
        " + "
    } else {
        " - "
    }
}
