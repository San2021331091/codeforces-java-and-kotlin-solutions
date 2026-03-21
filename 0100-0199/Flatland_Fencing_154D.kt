import java.io.BufferedOutputStream
import java.io.PrintWriter

enum class Flatland{
    FIRST,SECOND,DRAW
}
private val reader = System.`in`.bufferedReader()

private fun readLongs() : LongArray{
    return reader.readLine().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
}
fun main() {
    var (x1,x2,a,b) = readLongs()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    var d = x2 - x1
    var dir = 1
    if (a<=0 && b<=0){
        a = -b.also { b = -a }
        d = -d
        dir = -1
    }
    when{
        a<=0 ->{
            when{
                d !in a..b  -> printer.println(Flatland.DRAW.name)
                else ->{
                    printer.println("${Flatland.FIRST.name}\n$x2")
                }
            }
        }
        else ->{
            when{
                d < 0 -> printer.println(Flatland.DRAW.name)
                d % (a+b) == 0L -> printer.println(Flatland.SECOND.name)
                d % (a+b) !in a..b -> printer.println(Flatland.DRAW.name)
                else -> printer.println("${Flatland.FIRST.name}\n${ x2 - dir * (d / (a + b)) * (a + b)}")
            }
        }
    }
    printer.flush()
    printer.close()
}