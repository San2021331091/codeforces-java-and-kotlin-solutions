private const val  Pi = 3.14159265359;
fun main() {
    val n = readln().toInt()
    val radii = LongArray(n + 1)
    radii[0] = 0L
    val input = generateSequence { readln().trim() }.filter { it.isNotBlank() }.flatMap { it.split(" ").asSequence() }.iterator()
    repeat(n){
        i ->
        val k = i+1
        radii[k] = input.next().toLong()
    }
    radii.sort()
    var sum = 0.0
     for (k in n downTo 1 step 2){
         sum += radii[k] * radii[k] - radii[k - 1] * radii[k - 1]
     }
    sum *= Pi

    println(String.format("%.10f",sum))

}