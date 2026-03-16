import java.io.BufferedOutputStream
import java.io.PrintWriter

private fun String.subStr(pos: Int, len: Int): String {
    val end = (pos + len).coerceAtMost(this.length)
    return this.substring(pos, end)
}
private val String.nPos: Int get() = -1

fun main() {

    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.`out`))
    var ans = ""
    val s = reader.readLine().trim()
    for (p in 1 until s.length){
        val prefix = s.subStr(0,p)
        val suffix = s.subStr(s.length - p,p)
        if(prefix!=suffix){
            continue
        }
        val midPos = s.indexOf(prefix,1)
        if (midPos == s.nPos || midPos >= (s.length - p)){
            continue
        }
        ans = prefix
    }

    writer.println(ans.ifEmpty { "Just a legend" })
    reader.close()
    writer.flush()
    writer.close()
}