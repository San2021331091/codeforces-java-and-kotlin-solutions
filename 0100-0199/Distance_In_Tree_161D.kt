import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private lateinit var count: Array<IntArray>
private lateinit var edges: Array<MutableList<Int>>
private var n = 0
private var k = 0
private var output = 0L

private fun dfs(node: Int, from: Int) {
    count[node][0] = 1

    for (v in edges[node]) {
        if (v == from) continue

        dfs(v, node)

        for (d in 1..k) {
            output += count[node][d - 1].toLong() * count[v][k - d]
        }

        for (d in 1..k) {
            count[node][d] += count[v][d - 1]
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    k = st.nextToken().toInt()
    edges = Array(n + 1) { mutableListOf() }
    count = Array(n + 1) { IntArray(k + 1) { 0 } }
    repeat(n - 1) {
        val st2 = StringTokenizer(br.readLine())
        val a = st2.nextToken().toInt()
        val b = st2.nextToken().toInt()
        edges[a].add(b)
        edges[b].add(a)
    }

    dfs(from = -1, node = 1)

    println(output)
}