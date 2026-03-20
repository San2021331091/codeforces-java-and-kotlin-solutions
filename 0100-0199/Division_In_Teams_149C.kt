import java.util.Vector

private data class Pair<T,F>(val first: T, val second:F): Comparable<Pair<T,F>> where F : Number, T : Number, T: Comparable<T>, F:Comparable<F>{
    override fun compareTo(other: Pair<T, F>): Int {
        val cmp = this.first.compareTo(other.first)
        return if(cmp!= 0) cmp else this.second.compareTo(other.second)
    }
}
private fun <T> vectorOf(): Vector<T>{
    return Vector<T>()
}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val n = reader.readLine().toInt()
    val players = vectorOf<Pair<Long, Long>>()
    repeat(n){
        players.add(Pair(0,0))
    }
    val input = generateSequence { reader.readLine().trim()}.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence()}.iterator()
    for (p in 0 until n){
        val skill = input.next().toLong()
        players[p] = Pair(skill, p+1L)
    }
    players.sort()
    printer.write("${(n+1)/2}\n")
    for (p in 0 until n step 2){
        printer.write("${players[p].second} ")
    }
    printer.write("\n${n/2}\n")
    for (p in 1 until n step 2 ){
        printer.write("${players[p].second} ")
    }
    printer.write("\n")
    reader.close()
    printer.flush()
    printer.close()
}
