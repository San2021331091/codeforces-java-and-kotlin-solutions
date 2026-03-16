import java.io.BufferedOutputStream
import java.io.PrintWriter

@FunctionalInterface
private fun interface Solver{
    fun solve(p:Int,q:Int,r: Int):Int
}

private class NumberPositions{
    companion object{
        fun makeSolutions(n: Int, a: Int, b: Int): Int{
            return minOf(n - a , b + 1 )
        }
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val (s,u,v) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    val sl = NumberPositions::makeSolutions
    val sol = Solver(sl).solve(s,u,v)
    writer.println(sol)
    reader.close()
    writer.flush()
    writer.close()

}