package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numbers: Array<Int> = itemsFromArray.filterIsInstance<Int>().toTypedArray()
        if(numbers.isEmpty()){
            return 0
        }
        numbers.sortByDescending { Math.abs(it) }
        var result = 1
        var negative = 0
        var positive = 0
        for(i in 1..(numbers.size)) {
            val it = numbers[i-1]
            if( i > numberOfItems ) {
                if( 0 > result ) {
                    var nextPositive = 0
                    var nextNegative = 0
                    for(j in i..(numbers.size)) {
                        val nextNumber = numbers[j - 1]
                        if( 0 > nextNumber ) {
                            if( 0 == nextNegative ) {
                                nextNegative = nextNumber
                            }
                        } else {
                            if( 0 == nextPositive ) {
                                nextPositive = nextNumber
                            }
                        }
                    }
                    result = if( positive * nextPositive > negative * nextNegative ) {
                        result / negative * nextPositive
                    } else {
                        result / positive * nextNegative
                    }
                }
                return result
            }
            if( 0 > it) {
                negative = it
            } else {
                positive = it
            }
            result *= it
        }
        return result
    }
}
