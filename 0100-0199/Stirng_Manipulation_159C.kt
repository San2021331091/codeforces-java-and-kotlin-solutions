private const val NG = 26
fun main() {

    val k = readln().toLong()
    val s = readln()
    val t = StringBuffer()
    repeat(k.toInt()) {
        t.append(s)
    }
    val str = t.toString()

    val m = MutableList(NG) { mutableListOf<Int>() }
    val removed = mutableListOf<Boolean>()
    repeat(str.length){
        removed.add(false)
    }
    for (i in str.indices) {
        m[str[i] - 'a'].add(i)
    }
    val n = readln().toInt()


    repeat(n) {
        val (rStr,cStr) = readln().split("\\s+".toRegex()).toMutableList()
        val r = rStr.toInt()
        val cc = cStr[0] - 'a'
        val pos = m[cc][r - 1]
        removed[pos] = true
        m[cc].removeAt(r - 1)
    }
    val sb = StringBuffer()
    for (i in str.indices) {
        if (!removed[i]) sb.append(str[i])
    }
    print(sb.toString())
}