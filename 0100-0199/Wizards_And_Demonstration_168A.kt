fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (n,x,y) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    var clones = 0
    val required = 1.0 * n * y / 100.0
    if(x < required)
    {
        clones = required.toInt() - x
        if(clones < required - x)
            clones++
    }
    printer.write("$clones\n")
    reader.close()
    printer.flush()
    printer.close()
}