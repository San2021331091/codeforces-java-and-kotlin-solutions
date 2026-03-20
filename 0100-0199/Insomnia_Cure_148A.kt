import java.io.BufferedWriter

fun BufferedWriter.writeLine(value: Long){
   this.write("$value\n")
}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val input = generateSequence { reader.readLine().trim() }.takeWhile { it.isNotEmpty() }.flatMap { it.split("\n").asSequence() }.iterator()
    val k = input.next().toInt()
    val l = input.next().toInt()
    val m = input.next().toInt()
    val n = input.next().toInt()
    val d = input.next().toLong()
    var total = 0L
    for (u in 1.. d){
        if( u % k == 0L || u % l == 0L || u % m == 0L || u % n == 0L) ++total
    }

    printer.writeLine(total)
    reader.close()
    printer.flush()
    printer.close()
}