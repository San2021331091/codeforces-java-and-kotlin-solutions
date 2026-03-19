import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().toLong()
    val maxBlocks = 9L * (n + 1) - n
    var minBlocks = maxBlocks
    var x = 1L
    do {
        if (n % x != 0L) {
            x++
            continue
        }
        var y = 1L
        do {
            if ((n / x) % y != 0L) {
                y++
                continue
            }
            val candidateMin = (x + 1) * (y + 2) * (n / x / y + 2) - n
            if (candidateMin < minBlocks)
                minBlocks = candidateMin
            y++
        } while ((x * y * y) <= n)
        x++
    } while ((x * x * x) <= n)

    printer.println("$minBlocks $maxBlocks")
    reader.close()
    printer.flush()
    printer.close()
}