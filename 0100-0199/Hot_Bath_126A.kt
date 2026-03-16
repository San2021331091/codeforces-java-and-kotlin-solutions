import java.io.BufferedOutputStream
import java.io.PrintWriter

private interface HotBath
{
    fun solve(t1:Long,t2:Long,x1:Long,x2:Long,t0:Long):List<Long>
}
private class Bath : HotBath{
    override fun solve(
        t1: Long,
        t2: Long,
        x1: Long,
        x2: Long,
        t0: Long
    ): List<Long> {
        var best = 1e15
        var y1 = 0L
        var y2  = 0L
        var xNum1 = x1
        var xNum2 = x2
        while (xNum1 >= 0 && xNum2 >= 0) {
            val t = (1.0 * t1 * xNum1 + 1.0 * t2 * xNum2) / (1.0 * xNum1 + 1.0 * xNum2)
            if (t < t0) {
                xNum1--
                continue
            }
            if (t < best) {
                best = t
                y1 = xNum1
                y2 = xNum2
            }
            xNum2--
        }
        return listOf(y1,y2)
    }

}
fun main() {
    val reader = System.`in`.bufferedReader()
    val output = PrintWriter(BufferedOutputStream(System.`out`))
    val (a,b,c,d,e) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    val hb = ::Bath
    val (x,y) = hb().solve(a,b,c,d,e)
    output.println("$x $y")
    reader.close()
    output.flush()
    output.close()
}