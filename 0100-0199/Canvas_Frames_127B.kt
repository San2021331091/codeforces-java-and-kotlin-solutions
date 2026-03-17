import java.io.BufferedOutputStream
import java.io.PrintWriter

private const val LIMIT = 100
@FunctionalInterface
fun interface CanvasFrames {
    fun solve(ns: Int): Int
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))
    val numSticks = reader.readLine().trim().toInt()
    val cf = CanvasFrames { num: Int ->
        val array = IntArray(LIMIT + 1) { 0 }
        var total = 0
        val inp = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
        for(i in 0 until num) {
            val temp = inp[i]
            ++array[temp]
        }

        for (k in 0..LIMIT) {
            total += array[k] / 2
        }
        total /= 2
        total
    }
    writer.println(cf.solve(numSticks))
    reader.close()
    writer.flush()
    writer.close()
}