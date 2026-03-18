import java.io.BufferedWriter
import java.io.OutputStreamWriter
const val numDays = 7

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = BufferedWriter(OutputStreamWriter(System.`out`))
    var numPages = reader.readLine().toInt()
    val weekPages = IntArray(numDays) { 0 }
    var total = 0
    val tokenizer = generateSequence { reader.readLine() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence()}.iterator()
    for(k in 0 until numDays){
        weekPages[k] = tokenizer.next().toInt()
        total += weekPages[k]
    }
    numPages %= total
    if (numPages == 0) numPages = total

    for(k in 0.. numDays){
        if (numPages <= 0){
            printer.write("${k}\n")
            break
        }
        numPages -= weekPages[k]

    }
    reader.close()
    printer.flush()
    printer.close()
}