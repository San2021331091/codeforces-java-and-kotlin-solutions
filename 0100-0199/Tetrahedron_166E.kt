import java.io.BufferedWriter
const val a = 4
const val modNumber = 1000000007L
private fun BufferedWriter.writeLn(value: Long) = this.write("$value\n")

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val n = reader.readLine().toLong()
    var f = 0L; var g: Long; var fPrev = 0L; var gPrev = 1L
    for (k in 2L .. n){
        f = (a - 1L) * gPrev
        g = fPrev + (a-2) * gPrev
        f %= modNumber
        g %= modNumber
        fPrev = f
        gPrev = g
    }

    printer.writeLn(f)
    reader.close()
    printer.flush()
    printer.close()
}