import java.io.BufferedOutputStream
import java.io.PrintWriter

abstract class Vasilis {
    abstract fun solve(r1: Int, r2: Int, c1: Int, c2: Int, d1: Int, d2: Int): List<Int>
}

class TheWise : Vasilis() {
    override fun solve(
        r1: Int,
        r2: Int,
        c1: Int,
        c2: Int,
        d1: Int,
        d2: Int
    ): List<Int> {
        val x = if (((r1 + c1 - d2)) % 2 == 0) ((r1 + c1 - d2) / 2) else -1
        val y = if (((r1 + c2 - d1)) % 2 == 0) ((r1 + c2 - d1) / 2) else -1
        val z = if (((r2 + c1 - d1)) % 2 == 0) ((r2 + c1 - d1) / 2) else -1
        val w = if (((r2 + c2 - d2)) % 2 == 0) ((r2 + c2 - d2) / 2) else -1
        return listOf(x, y, z, w)
    }
}

fun main() {
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val reader = System.`in`.bufferedReader()
    val readInts = {
        reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    }
    val (a,b) = readInts()
    val (c,d) = readInts()
    val (e,f) = readInts()
    val (x, y, z, w) = TheWise().solve(r1 = a, r2 = b, c1 = c, c2 = d, d1 = e, d2 = f)
    val res = when {
        x < 1 || y < 1 || z < 1 || w < 1 || x > 9 || y > 9 || z > 9 || w > 9 || x == y || x == z || x == w || y == z || y == w || z == w -> "-1"
        else -> "$x $y\n$z $w"
    }
    reader.close()
    printer.println(res)
    printer.flush()
    printer.close()

}