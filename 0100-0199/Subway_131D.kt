import java.io.BufferedOutputStream
import java.io.PrintWriter
import java.util.*

private var cycleStart = -1
private var done = false
private val edges = mutableListOf<MutableList<Int>>()
private val visitedP = mutableListOf<Boolean>()
private val distance = mutableListOf<Int>()
private val parents = mutableListOf<Int>()

private fun findCycle(node: Int, caller: Int) {
    if (done) return
    if (parents[node] >= 0) {
        var currentParent = caller
        cycleStart = caller
        while (currentParent != node) {
            distance[currentParent] = 0
            currentParent = parents[currentParent]
        }
        distance[currentParent] = 0
        done = true
        return
    }
    parents[node] = caller
    for (p in edges[node].indices) {
        val nextNode = edges[node][p]
        if (nextNode == caller) continue
        findCycle(caller = node, node = nextNode)
    }
}

private fun dfs(node: Int, currentDist: Int) {

    if (visitedP[node]) return
    visitedP[node] = true
    for (p in edges[node].indices) {
        val nextNode = edges[node][p]
        if (visitedP[nextNode]) continue
        if (distance[nextNode] < 0) distance[nextNode] = 1 + currentDist
        dfs(node = nextNode, currentDist = distance[nextNode])
    }
}


fun main() {

    val reader = System.`in`.bufferedReader()
    val printer = PrintWriter(BufferedOutputStream(System.out))
    val n = reader.readLine().toInt()
    repeat(n + 1) {
        edges.add(mutableListOf())
        visitedP.add(false)
        distance.add(-1)
        parents.add(-1)
    }

    repeat (n) {
        val tokenizer = StringTokenizer(reader.readLine().trim())
        val a = tokenizer.nextToken().toInt()
        val b = tokenizer.nextToken().toInt()
        edges[a].add(b)
        edges[b].add(a)
    }

    findCycle(node = 1, caller = 1)
    dfs(currentDist = 0, node = cycleStart)
    for (p in 1..n) {
        printer.print("${distance[p]} ")
    }
    printer.println()
    reader.close()
    printer.flush()
    printer.close()

}