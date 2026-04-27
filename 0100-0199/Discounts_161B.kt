import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.PrintWriter

private data class PenStool(
    var order: Long,
    var price: Long,
    var kind: Long
) : Comparable<PenStool> {
    override fun compareTo(other: PenStool): Int {
        return when {
            this.kind != other.kind ->
                if (this.kind == 1L) -1 else 1

            else ->
                other.price.compareTo(this.price)
        }
    }
}

private fun BufferedReader.input() = this.readLine().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()

fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val (n, k) = reader.input()
    val itemVec = MutableList(n.toInt() + 1) { PenStool(0L, 0L, 0L) }
    var minPrice = 1e9.toLong()
    for (p in 1L..n) {
        itemVec[p.toInt()].order = p
        val (pr, ki) = reader.input()
        itemVec[p.toInt()].price = pr
        itemVec[p.toInt()].kind = ki
        if (itemVec[p.toInt()].price < minPrice) minPrice = itemVec[p.toInt()].price
    }
    itemVec.subList(1, n.toInt() + 1).sort()
    var totalPrice = 0.0
    for (p in 1..n) {
        if (itemVec[p.toInt()].kind == 1L && p < k)
            totalPrice += 0.5 * itemVec[p.toInt()].price
        else totalPrice += itemVec[p.toInt()].price
    }
    if (itemVec[k.toInt()].kind == 1L)
        totalPrice -= 0.5 * minPrice

    printer.println("%.1f".format(totalPrice))
    for (p in 1 until k) {
        printer.println("1 ${itemVec[p.toInt()].order}")
    }
    printer.print("${n - k + 1} ")
    for (p in k..n) {
        printer.print("${itemVec[p.toInt()].order} ")
    }
    printer.println()
    reader.close()
    printer.flush()
    printer.close()
}






