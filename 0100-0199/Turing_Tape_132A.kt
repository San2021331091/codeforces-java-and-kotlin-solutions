const val NC = 8
const val NH = 256

fun Char.reverseChar(): Int {
    var output = 0
    var code = this.code and 0xFF
    repeat(NC) {
        output = output * 2 + (code and 1)
        code = code shr 1
    }
    return output
}
fun main() {

    val line = readln()
    var previous = 0
    for (p in line.indices){
        val current = line[p].reverseChar()
        println((NH + previous - current) % NH)
        previous = current
    }
}