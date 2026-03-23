fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val n = reader.readLine().toInt()
    val input = generateSequence { reader.readLine() }.filter { it.isNotBlank() }.flatMap { it.split(" ").asSequence() }.iterator()
    val value = LongArray(n) { input.next().toLong() }
    var output: Long
    var currentMax = -30000000L
    for (div in 1 .. n/3){
        if(n%div!=0) continue
        for (rem in 0 until div){
            output = 0L
            for (k in 0 until n/div){
                output += value[div * k + rem]
            }
            if(output > currentMax) currentMax = output
        }
    }

    printer.write("$currentMax\n")
    reader.close()
    printer.flush()
    printer.close()
}