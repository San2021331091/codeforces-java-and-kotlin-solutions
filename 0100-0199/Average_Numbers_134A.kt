import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {

    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().trim().toLong()
    val array = LongArray(n.toInt())
    var total = 0L
    val line = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    for (k in 0 until n.toInt()){
        array[k] = line[k]
        total += array[k]
    }
    val indices = mutableListOf<Long>()
    for (k in 0 until n.toInt()){
        if (array[k] * n == total) indices.add(k.toLong())
    }
    printer.println(indices.size)
    indices.forEach { printer.print("${1L+it} ")}
    printer.println()
    reader.close()
    printer.flush()
    printer.close()
}