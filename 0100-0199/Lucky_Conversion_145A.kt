fun main() {
    val a = readln()
    val b = readln()
    var fTos = 0L
    var sTof = 0L

    for (k in a.indices){
        when{
            a[k] == '4' && b[k] == '7' -> ++fTos
            a[k] == '7' && b[k] == '4' -> ++sTof
        }
    }
    println(if (fTos > sTof) fTos else sTof)
}