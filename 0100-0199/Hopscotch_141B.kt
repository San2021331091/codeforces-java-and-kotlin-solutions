import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val (a,x,y) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    var output = -1L
    if(y in 1 until a){if(-a < 2*x && 2*x < a){output = 1;}}
    else if((y/a)% 2L == 0L && y > (y/a)*a && -a < x && x < 0){output = 3 * (y/a) / 2}
    else if((y/a)%2L == 0L && y > (y/a)*a && x > 0 && x < a){output = 3 * (y/a)/2 + 1}
    else if((y/a)%2 == 1L && y > (y/a)*a && -a < 2*x && 2*x < a){output = (3 * (y/a) + 1)/2}
    printer.println(output)
    reader.close()
    printer.flush()
    printer.close()
}