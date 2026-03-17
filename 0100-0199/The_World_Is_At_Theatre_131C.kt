fun choose(x : Int , y : Int): ULong{
    return if(y==0) 1UL else x.toULong() * choose(x-1, y-1)/y.toULong()
}
fun main() {

    val (n,m,t) = readln().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    var result = 0UL
    for (k in 4 until t){
        result += choose(n,k) * choose(m,t-k)
    }
    println(result)
}