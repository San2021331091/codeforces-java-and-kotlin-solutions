import java.io.BufferedReader
import java.io.BufferedWriter

private fun BufferedWriter.println(value: Long) = this.write("$value\n")

private fun <R> BufferedReader.readLine(mapper: (String) -> R) = this.readLine().split("\\s+".toRegex()).map(mapper)

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (_,_,b) = reader.readLine { it.toInt() }
    val compVec = reader.readLine { it.toLong() }.sorted()
    printer.println(compVec[b] - compVec[b - 1])
    reader.close()
    printer.flush()
    printer.close()
}