fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val k = reader.readLine().toInt()
    val input = reader.readLine()
    val n = input.length
    val posCount = MutableList(n + 1) { 0L }
    posCount[0] = 1
    var oneSofar = 0L
    var output = 0L
    repeat(n) { p ->
        if (input[p] == '1') ++oneSofar
        if (oneSofar >= k) output += posCount[(oneSofar - k).toInt()]
        ++posCount[oneSofar.toInt()]
    }
    writer.write("$output\n")
    reader.close()
    writer.flush()
    writer.close()
}