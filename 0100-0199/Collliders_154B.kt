import java.io.BufferedOutputStream
import java.io.PrintWriter
import java.util.TreeSet

private fun getDeterminedFactors(z:Long, tPrime: MutableList<Boolean>, operation:(Long, MutableList<Boolean>)->  MutableList<Long>): MutableList<Long>{
    return operation(z,tPrime)
}
private fun <T> treeSetOf(): TreeSet<T>{
    return TreeSet<T>()
}
private fun getDivisors(r:Long, qPrime: MutableList<Boolean>): MutableList<Long> {
    val solve = {
        x:Long, t:MutableList<Boolean> ->
        val ans = mutableListOf<Long>()
        var p = 2L
        while (p * p <= x ){
            if(x%p != 0L){
                p++
                continue
            }
            if (t[p.toInt()]) ans.add(p)
            if (t[(x/p).toInt()]) ans.add(x/p)
            p++
        }
        if (ans.isEmpty()) ans.add(x)
        ans
    }
    return getDeterminedFactors(r,qPrime,solve)

}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val (n,m) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    val isPrime = BooleanArray((n+1).toInt()){ true }
    isPrime[0] = false
    isPrime[1] = false
    var p = 2
    while (p * p <= n){
        if (!isPrime[p]) {
            p++
            continue
        }
        for (q in 2 * p .. n) isPrime[q.toInt()] = false
        p++
    }
    val active = MutableList((n + 1).toInt()) { 0L }
    val on = treeSetOf<Long>()
    repeat(m.toInt()){


    }


}
