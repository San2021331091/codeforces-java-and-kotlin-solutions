import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))

    val s = reader.readLine()
    val n = s.length
    val lps = IntArray(n)
    var j = 0

    for (i in 1 until n) {
        while (j > 0 && s[i] != s[j]) {
            j = lps[j - 1]
        }
        if (s[i] == s[j]) {
            j++
        }
        lps[i] = j
    }

    var len = lps[n - 1]
    while (len > 0) {
        for (i in 0 until n - 1) {
            if (lps[i] == len) {
                writer.println(s.take(len))
                writer.flush()
                return
            }
        }
        len = lps[len - 1]
    }

    writer.println("Just a legend")
    writer.flush()
}