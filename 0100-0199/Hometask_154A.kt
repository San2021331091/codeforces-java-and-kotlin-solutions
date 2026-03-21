import java.io.BufferedOutputStream
import java.io.PrintWriter

fun add(a:Long, b:Long, operation: (Long, Long) -> Long ): Long{
   return operation(a,b)
}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val input = reader.readLine().trim()
    val k = reader.readLine().toInt()
    var total = 0L
    val inp = generateSequence { reader.readLine().trim() }.takeWhile { it.isNotEmpty() }.flatMap { it.split(" ").asSequence() }.iterator()
    repeat(k){
        val forbidden = inp.next()
        var inside = false
        var first = 0L
        var second = 0L
        for(s in input.indices){
            if (!inside && input[s] != forbidden[0] && input[s] != forbidden[1]) {
                continue
            }
            if (inside && input[s] != forbidden[0] && input[s] != forbidden[1]) {

                inside = false
                var minimum = first
                if (first > second) {
                    minimum = second
                }
                total = add(total,minimum){
                    a,b -> a+b
                }
                first = 0
                second = 0
            } else if (input[s] == forbidden[0] || input[s] == forbidden[1]) {
                inside = true
                if (input[s] == forbidden[0]) {
                    ++first
                } else if (input[s] == forbidden[1]) {
                    ++second
                }
            }
        }

        if (inside){
            var minimum = first
            if (first > second){
                minimum = second
            }
            total = add(total,minimum){
                a,b -> a+b
            }
        }
    }
    printer.println(total)
    reader.close()
    printer.flush()
    printer.close()
}