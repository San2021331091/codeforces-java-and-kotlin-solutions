import java.io.BufferedOutputStream
import java.io.PrintWriter
import java.util.StringTokenizer

const val upperLimit = 5000

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().toInt()
    val present = BooleanArray(upperLimit + 1) { false }
    val st = StringTokenizer(reader.readLine().trim())
    for (k in 1 .. n){
        val temp = st.nextToken().toInt()
        present[temp] = true
    }
    var total = 0
    for (k in 1 .. n){
        if (!present[k]) ++total
    }
    printer.println(total)
    reader.close()
    printer.flush()
    printer.close()

}