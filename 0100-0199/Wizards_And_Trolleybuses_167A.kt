import java.io.BufferedWriter
import java.util.StringTokenizer
import kotlin.math.sqrt

private fun BufferedWriter.writeLine(value: Double) = this.write("${"%.5f".format(value)}\n")

fun main() {

    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (n,a,d) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    var y = -1.0; var x: Double
    repeat(n.toInt()) {
        val tokenizer = StringTokenizer(reader.readLine())
        val t = tokenizer.nextToken().toLong();
        val v = tokenizer.nextToken().toLong()
        x = when {
            (2 * d * a > v * v) -> {
                0.5 * v / a + 1.0 * d / v
            }
            else -> sqrt( 2.0 * d /a)
        }
        x += t
        y = if(y>x) y else x
        printer.writeLine(y)
    }
    reader.close()
    printer.flush()
    printer.close()
}