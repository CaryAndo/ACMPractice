package arrays

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


class ArrayUtilsKt {

    fun printThreeSums(arr : Array<Int>) {
        if (arr.size < 3) {
            return
        }

        val pairMap : MutableMap<Int, MutableList<Pair<Int, Int>>> = HashMap()

        for ((i, value) in arr.withIndex()) {
            if (i == arr.size-1) {
                break
            }

            for (j in i + 1 .. arr.size - 1) {
                val sum = value + arr[j]
                if (pairMap.containsKey(sum)) {
                    pairMap.get(sum)?.add(Pair(i, j))
                } else {
                    val newList : MutableList<Pair<Int, Int>> = ArrayList()
                    newList.add(Pair(i, j))
                    pairMap.put(sum, newList)
                }
            }
        }

        val returnSet : MutableSet<MutableList<Int>>  = HashSet()

        for ((i, value) in arr.withIndex()) {
            if (pairMap.containsKey(value * -1)) {
                val pairList = pairMap.get(value * -1)
                for (pair in pairList!!) {
                    if (i != pair.first && i != pair.second) {
                        val newTrio : MutableList<Int> = ArrayList()
                        newTrio.add(value)
                        newTrio.add(arr[pair.first])
                        newTrio.add(arr[pair.second])
                        Collections.sort(newTrio)
                        returnSet.add(newTrio)
                    }
                }
            }
        }

        println(returnSet)
    }
}
