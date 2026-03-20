import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val n = System.`in`.bufferedReader().readLine().toLong()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val primeDecomp = mutableListOf<Long>()
    var source = n
    var test = 2L

    while (test * test <= source) {
        if (source % test == 0L) {
            primeDecomp.add(test)
            source /= test
        } else test++
    }
    if (source > 1L) primeDecomp.add(source)

    when {
        primeDecomp.size <= 1 -> printer.println("1\n0")
        primeDecomp.size == 2 -> printer.println("2")
        primeDecomp.size > 2 -> printer.println("1\n${primeDecomp[0] * primeDecomp[1]}")
    }
    printer.flush()
    printer.close()
}