const val NP = 8
val dRow = intArrayOf(-1, -1, -1, 0, 0, 0, 1, 1, 1)
val dCol = intArrayOf(-1, 0, 1, -1, 0, 1, -1, 0, 1)
val initialState = MutableList(NP) {""}
val visited = Array(NP) { Array(NP) { BooleanArray(NP + 1) } }
fun dfs(inRow: Int, inCol: Int, step: Int): Boolean {
    if (step >= NP) return true

    if (visited[inRow][inCol][step]) return false
    visited[inRow][inCol][step] = true

    for (p in dRow.indices) {
        val row = inRow + dRow[p]
        val col = inCol + dCol[p]

        if (row !in 0 until NP || col !in 0 until NP) continue

        if (row - step >= 0 && initialState[row - step][col] == 'S') continue
        if (row - step - 1 >= 0 && initialState[row - step - 1][col] == 'S') continue

        if (dfs(row, col, step + 1)) return true
    }
    return false
}


fun main() {

   repeat(NP){
       i->
       initialState[i] = readln()
   }
    println(if(dfs(7,0,0)) "WIN" else "LOSE")

}