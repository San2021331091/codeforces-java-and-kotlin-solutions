import java.io.BufferedOutputStream
import java.io.PrintWriter
import java.util.*

private data class IPair<T : Comparable<T>, F : Comparable<F>>(val first: T, val second: F) : Comparable<IPair<T, F>> {
    override fun compareTo(other: IPair<T, F>): Int {
        val cmp = this.first.compareTo(other.first)
        return if (cmp != 0) cmp else this.second.compareTo(other.second)
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))
    val n = reader.readLine().trim().toInt()
    val events = mutableListOf<IPair<Long, Long>>()
    repeat(n) {
        val tokenizer = StringTokenizer(reader.readLine().trim())
        val start = tokenizer.nextToken().toLong()
        val finish = tokenizer.nextToken().toLong()
        events.add(IPair(start, finish))
    }
    events.sort()
    var count = 0L
    var currentMaxEnd = 0L
    repeat(n) { i ->
        when {
            events[i].second < currentMaxEnd -> ++count
            else -> currentMaxEnd = events[i].second
        }
    }
    writer.println(count)
    reader.close()
    writer.flush()
    writer.close()
}