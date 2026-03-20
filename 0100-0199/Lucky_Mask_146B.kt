fun luckyMask(inp: Long): Long{
    var output = 0L
    var multiply = 1L
    var input = inp
    while (input > 0){
        if (input % 10L == 4L || input % 10L == 7L){
            output += multiply * (input % 10)
            multiply *= 10L
        }
        input /= 10
    }

    return output

}

fun main() {

    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (a,b) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    var output = a + 1L
    while (luckyMask(output) != b) ++ output
    printer.write("$output\n")
    reader.close()
    printer.flush()
    printer.close()

}