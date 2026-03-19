import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    var (n,m) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    if (m > n){
      m = n.also { n = m }
    }
    when(m){
        1L -> writer.println("$n")
        2L -> writer.println(2L * (2L * (n / 4) + (if ((n % 4) < 2) (n % 4) else 2)))
        else -> writer.println( m * n - (n * m) / 2)
    }
    reader.close()
    writer.flush()
    writer.close()
}