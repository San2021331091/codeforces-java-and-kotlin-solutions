import java.io.BufferedReader

private fun BufferedReader.readInts(): IntArray {
    return this.readLine().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val input = reader.readInts()
    val (n,k,l,c,d) = input
    val p = input[5]
    val nl = input[6]
    val np = input[7]
    val minVal = minOf( p/(n * np) , minOf((k * l)/(n * nl),(c * d)/n))
    printer.write("$minVal\n")
    reader.close()
    printer.flush()
    printer.close()

}