import java.io.BufferedOutputStream
import java.io.PrintWriter

private const val NQ = 3

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().toInt()
    val nameVec = MutableList(n) {""}
    val numbers = MutableList(n) { MutableList(NQ) { 0 } }

    val maxNumbers = IntArray(NQ) { 0 }

    val inp = generateSequence { reader.readLine().trim() }.takeWhile { it.isNotEmpty() }
        .flatMap { it.split(" ").asSequence() }
        .iterator()

    for (k in 0 until n) {
        val num = inp.next().toInt()
        val currentName = inp.next()
        nameVec[k] = currentName
        repeat(num) {
            val temp = reader.readLine().trim()
            if (temp[0] == temp[1] && temp[1] == temp[3] &&
                temp[3] == temp[4] && temp[4] == temp[6] && temp[6] == temp[7]
            ) {
                ++numbers[k][0]
            } else if (temp[0] > temp[1] && temp[1] > temp[3] &&
                temp[3] > temp[4] && temp[4] > temp[6] && temp[6] > temp[7]
            ) {
                ++numbers[k][1]
            } else {
                ++numbers[k][2]
            }
        }

        repeat(NQ) { p ->
            if (numbers[k][p] > maxNumbers[p]) {
                maxNumbers[p] = numbers[k][p]
            }
        }
    }

    var moreThanOne = false
    printer.print("If you want to call a taxi, you should call: ")
    repeat(n) { k ->
        if (numbers[k][0] == maxNumbers[0]) {
            if (moreThanOne) printer.print(", ")
            printer.print(nameVec[k])
            moreThanOne = true
        }
    }
    printer.print(".\n")

    moreThanOne = false
    printer.print("If you want to order a pizza, you should call: ")
    repeat(n) { k ->
        if (numbers[k][1] == maxNumbers[1]) {
            if (moreThanOne) printer.print(", ")
            printer.print(nameVec[k])
            moreThanOne = true
        }
    }
    printer.print(".\n")

    moreThanOne = false
    printer.print("If you want to go to a cafe with a wonderful girl, you should call: ")
    repeat(n) { k ->
        if (numbers[k][2] == maxNumbers[2]) {
            if (moreThanOne) printer.print(", ")
            printer.print(nameVec[k])
            moreThanOne = true
        }
    }
    printer.print(".\n")

    printer.println()
    reader.close()
    printer.flush()
    printer.close()
}