import java.io.BufferedOutputStream
import java.io.PrintWriter
import java.util.TreeMap
import java.util.TreeSet

private data class IPairF<T : Comparable<T>, F : Comparable<F>>(val first: T, val second: F) : Comparable<IPairF<T, F>> {
    override fun compareTo(other: IPairF<T, F>): Int {
        val cmp = this.first.compareTo(other.first)
        return if (cmp != 0) cmp else this.second.compareTo(other.second)
    }
}

private fun <T: Number,F: Number> treeMapOf() : TreeMap<T,F>{
    return TreeMap<T,F>()
}
private fun <T> treeSetOf() : TreeSet<T>{
    return TreeSet<T>()
}

fun main() {
   val reader = System.`in`.bufferedReader()
   val writer = PrintWriter(BufferedOutputStream(System.out))
   val n = reader.readLine().toInt()
    val m = treeMapOf<Long, Long>()
   val tokenizer = generateSequence { reader.readLine() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
   repeat(n){
      val r = tokenizer.next().toLong()
       if (m.containsKey(r)) m[r] = m[r]!! + 1
        else{
            m.putIfAbsent(r,1L)
       } }
   val qs = treeSetOf<IPairF<Long, Long>>()
   for ((key,value) in m){
       qs.add(IPairF(value,key))
   }
    val v = mutableListOf<MutableList<Long>>()
    while (qs.size >= 3){
        val p1 = qs.pollLast()!!
        val p2 = qs.pollLast()!!
        val p3 = qs.pollLast()!!

        val np1 = IPairF(p1.first - 1, p1.second)
        val np2 = IPairF(p2.first - 1, p2.second)
        val np3 = IPairF(p3.first - 1, p3.second)

        if (np1.first > 0) qs.add(np1)
        if (np2.first > 0) qs.add(np2)
        if (np3.first > 0) qs.add(np3)

        val s = MutableList(3) { 0L }
        s[0] = p1.second
        s[1] = p2.second
        s[2] = p3.second
        s.sortDescending()
        v.add(s)
    }
    writer.println(v.size)
    for (p in v.indices){
        writer.println("${v[p][0]} ${v[p][1]} ${v[p][2]}")
    }
    reader.close()
    writer.flush()
    writer.close()
}