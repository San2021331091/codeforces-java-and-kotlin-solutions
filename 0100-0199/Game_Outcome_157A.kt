import java.io.BufferedOutputStream
import java.io.PrintWriter
private val reader = System.`in`.bufferedReader()
private val printer = PrintWriter(BufferedOutputStream(System.out))
private fun readInts(): Iterator<String> {
    return generateSequence { reader.readLine() }
        .flatMap { it.trim().split(" ").asSequence() }
        .iterator()
}
fun main() {

    val n = reader.readLine().toInt()
    val itr = readInts()
    val array = IntArray(n * n) { itr.next().toInt() }
    val rowSums = IntArray(n)
    val colSums = IntArray(n)
    repeat(n) {
        p->
        repeat(n){ row -> rowSums[row] += array[row * n + p]}
        repeat(n) { col -> colSums[col] += array[p * n + col] }
    }
    var total = 0
    for (row in 0 until n) {
        for (col in 0 until n) {
            if (colSums[col] > rowSums[row]) total++
        }
    }
    reader.close()
    printer.println(total)
    printer.flush()
    printer.close()
}