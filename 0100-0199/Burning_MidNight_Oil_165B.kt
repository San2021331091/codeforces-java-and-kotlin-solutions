private fun Long.totalSumDetermine(d: Long): Long {
    if (d <= 1L) return -1L
    var output = 0L;
    var currentDivisor = 1L
    while (currentDivisor <= this) {
        output += this / currentDivisor
        currentDivisor *= d
    }
    return output
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (n, k) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    var currentMin = 1L
    var currentMax = n
    while (currentMin + 1 < currentMax) {
        val currentMid = (currentMin + currentMax) / 2
        val testMid = currentMid.totalSumDetermine(k)
        when {
            testMid < n -> currentMin = currentMid
            else -> currentMax = currentMid
        }
    }
    printer.write("$currentMax\n")
    reader.close()
    printer.flush()
    printer.close()
}