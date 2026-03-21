private operator fun Long.plus(other:Boolean) = this + if(other) 1L else 0L

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    var numGroups = reader.readLine().toInt()
    val groups = LongArray(5) { 0L }
    var temp : Int
    val itr = generateSequence { reader.readLine() }.filter { it.isNotBlank() }.flatMap { it.trim().split(" ").asSequence() }.iterator()
    do{
        temp = itr.next().toInt()
        ++groups[temp]
    }
    while (--numGroups > 0L)

    var total = groups[4]
    total += groups[3]
    groups[1] -= groups[3]
    total += groups[2]/2 + groups[2]%2
    groups[1] -= 2 * (groups[2] % 2)
    if(groups[1] > 0){
        total += groups[1]/4 + (groups[1]%4 > 0)
    }
    printer.write("$total\n")
    reader.close()
    printer.flush()
    printer.close()
}