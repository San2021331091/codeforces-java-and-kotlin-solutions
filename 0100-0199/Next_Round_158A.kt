fun main() {
    val (n,k) = readln().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    val lines = generateSequence { readln() }.filter { it.isNotBlank() }.flatMap { it.split(" ").asSequence() }.iterator()
    val scores = IntArray(n) { lines.next().toInt() }
    scores.sort()
    val min = scores[n - k]
    var promoted = 0
    while(promoted < n && scores[n-1 - promoted] > 0 && scores[n-1 - promoted] >= min){++promoted}
    println(promoted)
}