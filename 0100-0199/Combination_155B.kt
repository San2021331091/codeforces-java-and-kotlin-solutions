import java.io.BufferedOutputStream
import java.io.PrintWriter

private val reader = System.`in`.bufferedReader()
private val printer = PrintWriter(BufferedOutputStream(System.out))

private fun readInts(): Iterator<String> {
    return generateSequence { reader.readLine() }
        .filter { it.isNotBlank() }
        .flatMap { it.split(" ").asSequence() }
        .iterator()
}

fun main() {
    val n = reader.readLine().toInt()
    val zeros = mutableListOf<Int>()
    var remaining = 1
    var total = 0L

    val p = readInts()

    repeat(n) {
        val a = p.next().toInt()
        val b = p.next().toInt()

        if (b == 0) {
            zeros.add(a)
        } else {
            total += a
            remaining += b - 1
        }
    }

    zeros.sort()

    var k = zeros.size - 1
    while (k >= 0 && remaining > 0) {
        total += zeros[k]
        k--
        remaining--
    }

    printer.println(total)
    reader.close()
    printer.flush()
    printer.close()
}