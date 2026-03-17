import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
   val reader = System.`in`.bufferedReader()
   val writer = PrintWriter(BufferedOutputStream(System.out))
   val n = reader.readLine().toInt()
    val array = LongArray(n)
    var maxElement = 0L
    var maxPos = 0L
    val line = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    for (p in 0 until n){
        array[p] = line[p]
        if (array[p] > maxElement){
            maxElement = array[p]
            maxPos = p.toLong()
        }
    }
    if (maxElement == 1L){
        array[maxPos.toInt()] = 2L
    }
    else{
        array[maxPos.toInt()] = 1L
    }
    array.sort()
    array.forEach { writer.print("$it ")}
    writer.println()
    reader.close()
    writer.flush()
    writer.close()
}