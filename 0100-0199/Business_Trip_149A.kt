private const val numMonths = 12
@OptIn(ExperimentalUnsignedTypes::class)
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val lowerBound = reader.readLine().toInt()
    val rate = UIntArray(numMonths) { 0U }
    val inp = generateSequence { reader.readLine().trim() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
    for (k in 0 until numMonths){
        rate[k] = inp.next().toUInt()
    }
    rate.sort()
    var totalGrowth = 0U
    var output = 0
    while (totalGrowth < lowerBound.toUInt() && output < numMonths){
        output++
      totalGrowth += rate[numMonths - output]
    }

    if (totalGrowth < lowerBound.toUInt()){
        output = -1
    }

    reader.close()
    printer.write("$output\n")
    printer.flush()
    printer.close()
}