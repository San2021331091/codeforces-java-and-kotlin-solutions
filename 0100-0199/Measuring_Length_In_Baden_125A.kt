import java.io.BufferedOutputStream
import java.io.PrintWriter

fun measuringLengthInBaden(n : Long):List<Long>{
   var num = n
    when{
        num % 3L == 1L -> --num
        num % 3L == 2L -> ++num
    }
    val feet = num / 36L
    val inches = (num - 36L * feet) / 3L
    return listOf(feet,inches)
}


fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))
    val n = reader.readLine().trim().toLong()
    val mes = ::measuringLengthInBaden
    val (feet,inches) = mes(n)
    writer.println("$feet $inches")
    reader.close()
    writer.flush()
    writer.close()
}