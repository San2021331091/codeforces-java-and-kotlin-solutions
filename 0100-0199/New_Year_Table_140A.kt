import kotlin.math.sin
const val PI =  3.14159265359
fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val input = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    val (n,R,r) = input.toIntArray()
    when{
        (n == 1 && r <= R) || (n == 2 && 2 * r <= R) || (n >= 3 && r < R && sin( PI / n) >= 1.0 * r / (1.0 * R - r)) -> writer.write("YES\n")
        else -> writer.write("NO\n")
    }
    reader.close()
    writer.flush()
    writer.close()
}