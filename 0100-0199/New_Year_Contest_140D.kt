import java.io.BufferedOutputStream
import java.io.PrintWriter

const val half = 360
const val duration = 720

fun main() {

    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().toInt()
    val time = MutableList(n) { 0 }
    val tokenizer = generateSequence { reader.readLine() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
    for (p in 0 until n){
        time[p] = tokenizer.next().toInt()
    }
    time.sort()
    var penalty = 0
    var current = 10
    var solved = 0
    for (p in 0 until n ){
        current += time[p]
        if (current > duration) break
        ++solved
        if (current > half) penalty += (current - half)
    }
    writer.println("$solved $penalty")
    reader.close()
    writer.flush()
    writer.close()
}