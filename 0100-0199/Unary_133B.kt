import java.util.TreeMap

private fun <T,F> treeMapOf(): TreeMap<T,F>{
    return TreeMap<T,F>()
}
fun main() {

    val commands = treeMapOf<Char, Int>()
    commands.putIfAbsent('>',8)
    commands.putIfAbsent('<',9)
    commands.putIfAbsent('+',10)
    commands.putIfAbsent('-',11)
    commands.putIfAbsent('.',12)
    commands.putIfAbsent(',',13)
    commands.putIfAbsent('[',14)
    commands.putIfAbsent(']',15)

    val input = readln()
    val multiplier = 16
    val divisor = 1000003
    var total = 0L
    input.forEach {
        p->
        total = multiplier * total + commands[p]!!
        total %= divisor
    }
    println(total)
}