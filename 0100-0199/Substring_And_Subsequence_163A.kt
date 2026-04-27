private const val MOD = 1000000007L

fun main() {
    val s = readln()
    val t = readln()
    val n = s.length
    val m = t.length
    val f = Array(n) { LongArray(m) { 0L } }
    var count = 0L

    repeat(n){
        p ->
        repeat(m){
            q->
            if (s[p] == t[q])
            {
                f[p][q] += 1L + (if (p > 0 && q> 0) f[p-1][q-1] else 0L)
                f[p][q] %= MOD
            }
            if (q + 1 < m) f[p][q+1] = f[p][q]

        }
        count += f[p][m-1]
        count %= MOD
    }
    println(count)
}