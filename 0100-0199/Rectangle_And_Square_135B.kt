fun LongArray.nextPermutation(): Boolean {
    var i = this.size - 2
    while (i >= 0 && this[i] >= this[i + 1]) i--
    if (i < 0) return false

    var j = this.size - 1
    while (this[j] <= this[i]) j--

    // swap i and j
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp

    // reverse from i+1 to end
    var left = i + 1
    var right = this.size - 1
    while (left < right) {
        val t = this[left]
        this[left] = this[right]
        this[right] = t
        left++
        right--
    }

    return true
}

private const val NZ = 8


fun main() {
    val x = LongArray(NZ)
    val y = LongArray(NZ)
    for (p in 0 until NZ) {
        val (xi, yi) = readln().split("\\s+".toRegex()).map { it.toLong() }.toLongArray()
        x[p] = xi
        y[p] = yi
    }
    val rv = LongArray(NZ)
    for (p in 0 until NZ ){
        rv[p] = p.toLong()
    }
    var possible = false
    do {
        val M = NZ/2
        val dx = LongArray(M)
        val dy = LongArray(M)
        for (p in 0 until M){
            dx[p] = x[rv[(p + 1) % M].toInt()] - x[rv[p].toInt()]
            dy[p] = y[rv[(p + 1) % M].toInt()] - y[rv[p].toInt()] }
        if((dx[0]* dy[2] != dy[0] * dx[2]) || (dx[1] * dy[3] != dy[1] * dx[3]) || (dx[0] * dx[1] + dy[0] * dy[1] != 0L) || (dx[0] * dx[0] + dy[0] * dy[0] != dx[1] * dx[1] + dy[1] * dy[1])){continue}
        for (p in M..<NZ) {
            dx[p - M] = x[rv[M + (p + 1) % M].toInt()] - x[rv[p].toInt()]
            dy[p - M] = y[rv[M + (p + 1) % M].toInt()] - y[rv[p].toInt()]
        }
        if ((dx[0] * dy[2] !== dy[0] * dx[2]) || (dx[1] * dy[3] !== dy[1] * dx[3]) || (dx[0] * dx[1] + dy[0] * dy[1] !== 0L)) {
            continue
        }
        possible = true
        break
    }
    while (rv.nextPermutation())

    when(possible){
        true ->{
            println("YES")
            for (p in 0 until NZ/2){
                print("${1 + rv[p]} ")
            }
            println()
            for (p in NZ/2 until NZ){
                print("${1 + rv[p]} ")
            }
            println()
        }
        else -> println("NO")
    }

}

