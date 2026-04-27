import java.io.BufferedReader
import java.util.*

private fun <T> mutableVectorOf() = Vector<T>()
private fun BufferedReader.input() = this.readLine()

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val n = reader.input().toInt()
    val points = mutableVectorOf<Pair<Int, Int>>()
    var x: Int; var y: Int
    repeat(n) {
        val nT = StringTokenizer(reader.input())
        x = nT.nextToken().toInt()
        y = nT.nextToken().toInt()
        points.add(Pair(x, y))
    }
    val neighbor = BooleanArray(4)
    Arrays.fill(neighbor,false)
    var central = 0
    repeat(n) { a ->
        x = points[a].first
        y = points[a].second
        neighbor[0] = false
        neighbor[1] = false
        neighbor[2] = false
        neighbor[3] = false
        for (b in 0 until n) {
            if (b == a) continue
            if (points[b].first == x && points[b].second < y) {
                neighbor[0] = true
            } else if (points[b].first == x && points[b].second > y) {
                neighbor[1] = true
            } else if (points[b].first < x && points[b].second == y) {
                neighbor[2] = true
            } else if (points[b].first > x && points[b].second == y) {
                neighbor[3] = true
            }
            if (neighbor[0] && neighbor[1] && neighbor[2] && neighbor[3]) {
                ++central
                break
            }
        }
    }

    writer.write("$central\n")
    reader.close()
    writer.flush()
    writer.close()
}