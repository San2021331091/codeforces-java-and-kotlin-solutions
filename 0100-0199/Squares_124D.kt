import java.io.BufferedOutputStream
import java.io.PrintWriter
import kotlin.math.abs

fun Long.add(x: Long):Long{
    return this + x
}
fun Long.sub(x: Long): Long{
    return this - x
}

fun interface MathematicalOperation{
    fun apply(a: Long,b: Long): Long
}

enum class Operation : MathematicalOperation{
    PLUS {
        override fun apply(a: Long, b: Long): Long {
          return a.add(b)
        }
    },
    MINUS {
        override fun apply(a: Long, b: Long): Long {
            return a.sub(b)
        }
    }

}
fun performOperation(op : Operation,a:Long,b: Long) : Long{
    return when(op.name){
        "PLUS" -> op.apply(a,b)
        "MINUS" -> op.apply(a,b)
        else -> 0L
    }
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val input = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
    val (a,b,x1,y1,x2) = input
    val y2 = input[5]
    val t = ::performOperation
    val xA = t(Operation.PLUS,x1,y1)
    val yA = t(Operation.MINUS,x1,y1)
    val xB = t(Operation.PLUS,x2,y2)
    val yB = t(Operation.MINUS,x2,y2)
    val diffX = abs(xA / (2L * a) - xB / (2L * a) + (if(xA > 0L) 1L else 0L) - (if(xB > 0L) 1L else 0L))
    val diffY = abs(yA / (2 * b) - yB / (2 * b) + (if(yA > 0) 1 else 0) - (if(yB > 0) 1 else 0))
    writer.println(maxOf(diffX,diffY))
    reader.close()
    writer.flush()
    writer.close()
}