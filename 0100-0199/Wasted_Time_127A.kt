import java.io.BufferedOutputStream
import java.io.PrintWriter
import kotlin.math.sqrt

const val speed = 50
fun main() {

    val reader = System.`in`.bufferedReader()
    val writer = PrintWriter(BufferedOutputStream(System.out))
    val (numPoints,numPapers) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    var distance = 0.0
    var (oldX,oldY) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    repeat(numPoints - 1)
    {
        val (newX,newY) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
        distance += sqrt(((newX - oldX)*(newX - oldX) + (newY - oldY)*(newY - oldY)).toDouble());
        oldX = newX
        oldY = newY
    }

    writer.println("%.9f".format(numPapers * distance / speed))
    reader.close()
    writer.flush()
    writer.close()
}