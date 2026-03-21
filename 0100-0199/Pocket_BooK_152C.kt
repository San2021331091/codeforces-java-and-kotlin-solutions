import java.util.TreeSet

const val NV =  1000000007
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val (n,m) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    val letterSet = mutableListOf<TreeSet<Char>>()
    repeat(m){
        val temp = TreeSet<Char>()
        letterSet.add(temp)
    }
    repeat (n){
        val temp = reader.readLine().trim()
        repeat(m){
            p->
            letterSet[p].add(temp[p])
        }
    }
    var output = 1L
    repeat(m){
        p->
        output *= letterSet[p].size
        output %= NV
    }
    printer.write("$output\n")
    reader.close()
    printer.flush()
    printer.close()
}