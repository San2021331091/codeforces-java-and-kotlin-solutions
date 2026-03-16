import java.io.BufferedOutputStream
import java.io.PrintWriter

private fun String.subStr(pos: Int, len: Int): String {
    val end = (pos + len).coerceAtMost(this.length)
    return this.substring(pos, end)
}

fun main() {

    val reader = System.`in`.bufferedReader()
    val output = PrintWriter(BufferedOutputStream(System.`out`))
    val s = reader.readLine().trim()
    var cnt = 0L
    for (p in 1 until s.length){
        if(s[p] == '<' || s[p] == '>' || s[p] == '/')
        {
            continue
        }
       if (s[p-1] == '<'){
           val spaces = String(CharArray(2 * cnt.toInt()){' '})
           val cur = spaces + s.subStr(p - 1,3)
           output.println(cur)
           ++cnt
       }
       else if(s[p-1] == '/'){
           --cnt
           val spaces = String(CharArray(2 * cnt.toInt()){' '})
           val cur = spaces + s.subStr(p - 2,4)
           output.println(cur)
       }
    }
    output.println()
    reader.close()
    output.flush()
    output.close()
}


