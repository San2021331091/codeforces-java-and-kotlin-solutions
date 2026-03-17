import java.io.BufferedOutputStream
import java.io.PrintWriter

private const val MOD = 1000000007L
private const val NXP = 2007

interface GAMES{
    fun solve(v : MutableList<MutableList<Long>>) : Long
}
fun main() {

    val f = MutableList(NXP) { MutableList(NXP) { 0L } }
    for (p in 0 until NXP) f[p][0] = 1L

    for (p in 1 until NXP) {
        for (q in 1..p) {
            f[p][q] = (f[p - 1][q - 1] + f[p - 1][q]) % MOD
        }
    }
    val t = object : GAMES{
        override fun solve(v: MutableList<MutableList<Long>>): Long {
            val reader = System.`in`.bufferedReader()
            val (n,m,k) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
            return v[n - 1][2 * k] * v[m - 1][2 * k] % MOD
        }
    }
    val print = PrintWriter(BufferedOutputStream(System.out))
    print.println(t.solve(v = f))
    print.flush()
    print.close()
}