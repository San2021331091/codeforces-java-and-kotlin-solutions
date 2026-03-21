fun main() {
    val s = readln()
    val t = readln()
    val n = s.length
    var minDiff = s.length + t.length
    for (startPos in -t.length .. n){
        var diff = 0
        for (p in t.indices){
            when{
                ((p + startPos < 0) || (p+startPos) >= s.length) ->{
                    ++diff
                }
                else->{
                    diff += if((s[startPos + p] != t[p])) 1 else 0
                }
            }
        }
        if (diff < minDiff) minDiff = diff
    }
    println(minDiff)
}