private const val P = 256
private fun isPrime(a: Int, p: Int): Boolean {
    return (a <= p) || ((a % p != 0) && (isPrime(a, p + 1)))
}

fun main() {

    val freq = IntArray(P) { 0 }
    val s = readln()
    val len = s.length
    for (p in 0 until len) {
        ++freq[s[p].code]
    }
    val t = CharArray(len) { '\u0000' }

    val mIndex = freq.indices.maxByOrNull { freq[it] } ?: 0
    val prime = ::isPrime
    for (p in 1 until len) {
        if ((p < len / 2) || (!prime(p + 1, 2))) {
            t[p] = mIndex.toChar()
            freq[mIndex]--

        }
    }
    val res = when {

        freq[mIndex] < 0 -> "NO\n"
        else -> {
            var q = 0
            for (p in 0 until len) {
                if (t[p] == '\u0000') {
                    while (freq[q] == 0) q++
                    t[p] = q.toChar()
                    freq[q]--
                }
            }
            "YES\n${t.joinToString("")}"
        }
    }

    print(res)

}