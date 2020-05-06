package subtask6

import java.lang.StringBuilder

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        val sb = StringBuilder()
        sb.append("[")
        if (count%2==1) for (item in getList("[0", count-1, 0)) sb.append(item)
        sb.append("]")
        return sb.toString()
    }

    private fun getList(s: String, symbol: Int, free: Int): ArrayList<String>{
        return if (symbol==0) arrayListOf("$s]")
        else {
            val arr = getList("$s,0,0", symbol - 2, free+1)
            if (free>0) arr.addAll(getList("$s,null,null", symbol, free-1))
            arr
        }
    }
}
