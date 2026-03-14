@FunctionalInterface
fun interface Evaluate{
    fun solve(luckyVec: MutableList<Long>) : Long
}
fun findNext(luckyVec : MutableList<Long>) : MutableList<Long>{
    var done = false
    for (p in luckyVec.indices){
        if(luckyVec[p] == 4L){
            luckyVec[p] = 7L;
            done = true
            break
        }
        else{
            luckyVec[p] = 4
        }
    }

    if (!done){
        luckyVec.add(4L)
    }

    return luckyVec
}


fun luckyEvaluate(luckyVec: MutableList<Long>): Long{
    var output = 0L
    for (p in luckyVec.size - 1 downTo 0){
        output = 10 * output + luckyVec[p]
    }
    return output
}

fun main() {

    var luckyDigits = MutableList(1) { 4L }
    val (left,right) = readln().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    var currentNumber = left
    val ev = Evaluate(::luckyEvaluate)
    while (ev.solve(luckyDigits) < left){
       luckyDigits = findNext(luckyDigits)
    }
    var total = ev.solve(luckyDigits)
    while (currentNumber < right){
        val currentLucky = ev.solve(luckyDigits)
        val dist = if(currentLucky < right){
            currentLucky - currentNumber
        } else{
            right - currentNumber
        }
        total += currentLucky * dist
        currentNumber = currentLucky
        luckyDigits = findNext(luckyDigits)

    }
    println(total)
}