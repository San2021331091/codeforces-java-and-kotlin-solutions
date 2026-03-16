import java.io.BufferedOutputStream
import java.io.PrintWriter

fun <T : Comparable<T>> MutableList<T>.nextPermutation(): Boolean {
    var i = this.size - 2
    while (i >= 0 && this[i] >= this[i + 1]) i--
    if (i < 0) return false

    var j = this.size - 1
    while (this[j] <= this[i]) j--

    this[i] = this[j].also { this[j] = this[i] }

    var left = i + 1
    var right = this.size - 1
    while (left < right) {
        this[left] = this[right].also { this[right] = this[left] }
        left++
        right--
    }

    return true
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val (n, k) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()

    val perm = MutableList(k) { it }
    val numbers = MutableList(n) { MutableList(k) { 0 } }

    for (p in 0 until n) {
        val input = reader.readLine().trim()
        for (q in 0 until k) {
            numbers[p][q] = input[q] - '0'
        }
    }

    var minDiff = 1e10.toLong()

    do {
        var minNum = 1e10.toLong()
        var maxNum = 0L

        for (p in 0 until n) {
            var current = 0L
            for (q in 0 until k) {
                current = 10L * current + numbers[p][perm[q]]
            }
            if (current < minNum) minNum = current
            if (current > maxNum) maxNum = current
        }

        val diff = maxNum - minNum
        if (diff < minDiff) minDiff = diff

    } while (perm.nextPermutation())

    writer.println(minDiff)
    reader.close()
    writer.flush()
    writer.close()
}