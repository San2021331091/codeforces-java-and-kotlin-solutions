import java.io.BufferedOutputStream
import java.io.PrintWriter

const val scale = 10
fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))
    val n = reader.readLine().trim().toInt()
    val count = LongArray(2 * scale + 1) { 0L }
    val line = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    repeat(n){
        i->
        val temp = line[i]
        count[scale + temp]++
    }
    var total = 0L
    for (k in 0 until scale)
    {
        total += count[k] * count[2 * scale - k]
    }
    total += count[scale] * (count[scale] - 1)/2
    writer.println(total)
    reader.close()
    writer.flush()
    writer.close()
}