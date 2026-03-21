import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.PrintWriter

private const val maxSteps = 1000000000L
private fun BufferedReader.readInts(): LongArray{
    return this.readLine().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
}
fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val (yardX,yardY) = reader.readInts()
    var (currentX,currentY) = reader.readInts()
    var total = 0L
    val numVectors = reader.readLine().toInt()
    repeat(numVectors){
        val (vectorX,vectorY) = reader.readInts()
        var numStepsX = maxSteps
        when{
            vectorX > 0 ->{
                numStepsX = (yardX-currentX)/vectorX
            }
            vectorX < 0 ->{
                numStepsX = (currentX - 1)/(-vectorX)
            }
        }
        var numStepsY = maxSteps
        when{
            vectorY>0 ->{
                numStepsY = (yardY - currentY)/vectorY
            }
            vectorY < 0 ->{
                numStepsY = (currentY - 1)/(-vectorY)
            }
        }
        var numSteps = 0L
        if(numStepsX > 0 && numStepsY > 0){
            numSteps = minOf(numStepsX,numStepsY)
        }
        currentX += numSteps * vectorX
        currentY += numSteps * vectorY
        total += numSteps
    }

    printer.println(total)
    reader.close()
    printer.flush()
    printer.close()
}