import java.io.BufferedWriter
import java.util.StringTokenizer

private fun dfs(a: Long, b: Long): Boolean = when {
    a == 0L -> true
    dfs(b % a, a) -> false
    a % 2L == 1L -> ((b / a) % 2L) == 1L
    else -> ((b / a) % (a + 1L)) % 2L == 1L
}

private fun BufferedWriter.writeLine(value: Boolean) = this.write("${ if(value) "Second" else "First"}\n")

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val t = reader.readLine().toInt()
    repeat(t){
       val tokenizer = StringTokenizer(reader.readLine())
       var a = tokenizer.nextToken().toLong(); var b = tokenizer.nextToken().toLong()
        if(a > b){
                a = a xor b
                b = a xor b
                a = a xor b
            }

        printer.writeLine((dfs(a,b)))
    }
    reader.close()
    printer.flush()
    printer.close()
}