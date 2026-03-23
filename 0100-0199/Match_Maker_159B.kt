import java.io.BufferedReader

private const val NS = 1000
private val reader = System.`in`.bufferedReader()
private val printer = System.out.bufferedWriter()
private fun BufferedReader.readInts(): IntArray {
    return this.readLine().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
}
fun main() {
    val (n,m) = reader.readInts()
    val markers = MutableList(NS + 1) { MutableList(NS + 1) { 0 } }
    val caps = MutableList(NS + 1) { MutableList(NS + 1) { 0 } }
    val markerSizes = IntArray(NS + 1) { 0 }
    val capSizes = IntArray(NS + 1) { 0 }
    for (k in 0 .. NS){
        markerSizes[k] = 0
        capSizes[k] = 0
    }

    repeat(n){
        val input = reader.readInts()
        val currentColor = input[0]
        val currentSize = input[1]
        ++markerSizes[currentSize]
        ++markers[currentSize][currentColor]
    }

    repeat(m){
        val input = reader.readInts()
        val currentColor = input[0]
        val currentSize = input[1]
        ++capSizes[currentSize]
        ++caps[currentSize][currentColor]
    }
    var totalMatching = 0
    var beautifulMatching = 0
    for (k in 1..NS){
       totalMatching += minOf(markerSizes[k],capSizes[k])
    }
    for (row in 1 .. NS){
        for (col in 1 .. NS){
            beautifulMatching += minOf(markers[row][col],caps[row][col])
        }
    }
    printer.write("$totalMatching $beautifulMatching\n")
    reader.close()
    printer.flush()
    printer.close()

}