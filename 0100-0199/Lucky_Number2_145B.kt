import java.io.BufferedOutputStream
import java.io.PrintWriter

fun main() {
    val reader = System.`in`.bufferedReader()
    var (a,b,c,d) =reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    val printer = PrintWriter(BufferedOutputStream(System.out))
    if ((c>d+1) || (d>c+1)){
        printer.println("-1")
        printer.flush()
        printer.close()
        return
    }
    a -= c
    b -= c
    var left = false
    var right = false

    if (c == d){
        if(a > 0) {
            --a
            right = true
        }
        else{
            left = true
            --b
        }
    }
    else if(d > c){
        --a
        --b
        left = true
        right = true
    }
    if (a < 0 || b < 0) {
        printer.println("-1")
        printer.flush()
        printer.close()
        return
    }
    if (left){
        printer.print("7")
    }
    repeat(a.toInt()){
        printer.print("4")
    }
    repeat(c.toInt()){
        printer.print("47")
    }
    repeat(b.toInt()){
        printer.print("7")
    }
    if (right) printer.print("4")
    printer.println()
    reader.close()
    printer.flush()
    printer.close()

}