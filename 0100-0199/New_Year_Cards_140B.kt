import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().trim().toInt()
    val mat = MutableList(n + 1) { MutableList(n + 1) { 0L } }
    val tokenizer = generateSequence { reader.readLine() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
    for (p in 1.. n){
        for (q in 1 .. n){
            mat[p][q] = tokenizer.next().toLong()
        }
    }
    for (p in 1 .. n){
        mat[0][p] = tokenizer.next().toLong()
    }
    for (p in 1L .. n){
        var q = 0L
        var k = 0L
        do {
            ++q
            if (mat[p.toInt()][q.toInt()] == p) continue
           k = 1L
            while(mat[0][k.toInt()]>mat[p.toInt()][q.toInt()]||mat[0][k.toInt()]==p){
                ++k
            }
        }   while (mat[0][k.toInt()]!= mat[p.toInt()][q.toInt()])
        writer.print("${mat[p.toInt()][q.toInt()]} ")

    }
    writer.println()
    reader.close()
    writer.flush()
    writer.close()

}