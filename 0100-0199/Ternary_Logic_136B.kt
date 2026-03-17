import java.io.BufferedOutputStream
import java.io.PrintWriter

fun Long.decimalToTernary() : MutableList<Int>{
    val output = mutableListOf<Int>()
    var num = this
    while (num > 0){
        output.add((num % 3).toInt())
        num/= 3L
    }
    return output
}

fun MutableList<Int>.ternaryToDecimal() : Long{
    var output = 0L
    for (k in this.size - 1 downTo 0 )
    {
        output = 3 * output + this[k]
    }
    return output
}

fun MutableList<Int>.inverseOperation(y: MutableList<Int>): MutableList<Int> {
    val output = mutableListOf<Int>()
    val maxLen = maxOf(this.size, y.size)
    for (k in 0 until maxLen){
        var temp = 0
        if(k < this.size) temp += 3 + this[k]
        if(k < y.size) temp += 3 - y[k]
        output.add(temp % 3)
    }
    return output
}


fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.`out`))
    val (a,c) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    val aTernary = a.decimalToTernary()
    val cTernary = c.decimalToTernary()
    val bTernary = cTernary.inverseOperation(aTernary)
    val b = bTernary.ternaryToDecimal()
    printer.println(b)
    reader.close()
    printer.flush()
    printer.close()
}