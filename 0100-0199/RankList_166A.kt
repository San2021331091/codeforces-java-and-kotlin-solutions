import java.util.StringTokenizer

private const val mult = 100
fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val (n,k) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    val array = IntArray(n)
    for (p in 0 until n){
        val tokenizer = StringTokenizer(reader.readLine().trim())
        val solved = tokenizer.nextToken().toInt()
        val penalty = tokenizer.nextToken().toInt()
        array[p] = mult * solved - penalty
    }
    array.sort()
    val seekScore = array[n - k]; var result = 0
     repeat(n){
         p->
         if(array[p] == seekScore) ++result
     }
   writer.write("$result\n")
   reader.close()
   writer.flush()
   writer.close()
}