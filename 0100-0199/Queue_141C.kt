import java.io.BufferedOutputStream
import java.io.PrintWriter

private data class IPairTF<T,F>(var first: T, var second: F): Comparable<IPairTF<T,F>> where T:Number, T: Comparable<T>, F:Comparable<F> {
    override fun compareTo(other: IPairTF<T, F>): Int {
        val cmp = this.first.compareTo(other.first)
        return if(cmp!= 0) cmp else this.second.compareTo(other.second)
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().trim().toLong()
    val a = mutableListOf<IPairTF<Long, String>>()
    repeat(n.toInt()){
        a.add(IPairTF(0L,""))
    }
    val tokenizer = generateSequence { reader.readLine() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
    for(p in 0 until n.toInt()){
        a[p].second = tokenizer.next()
        a[p].first = tokenizer.next().toLong()
    }
    a.sort()
    var possible = true
    val h = LongArray(n.toInt())
    for (p in 0 until n.toInt()){
        h[p] = p - a[p].first
        if (h[p] < 0){
            possible = false
            break
        }
        ++h[p]
        for (q in 0 until p){
            if(h[q] >= h[p]) ++h[q]
        }
    }

   when{
       possible ->{
           for (p in 0 until n.toInt()){
               printer.println("${a[p].second} ${h[p]}")
           }
       }
       else -> printer.println("-1")
   }

    printer.println()
    reader.close()
    printer.flush()
    printer.close()
}