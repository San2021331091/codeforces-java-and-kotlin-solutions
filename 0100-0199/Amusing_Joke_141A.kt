const val alphaLength = 26
fun main() {
    val first = CharArray(alphaLength) { 0.toChar() }
    val second = CharArray(alphaLength) { 0.toChar() }
    var line  = readln()
    for (k in line.indices){
        first[line[k] - 'A']++
    }
    line = readln()
    for (k in line.indices){
        first[line[k] - 'A']++
    }
    line = readln()
    for (k in line.indices){
        second[line[k] - 'A']++
    }
    var output = "YES"
    for (k in 0 until alphaLength){
        if(first[k] != second[k]){
            output = "NO"
            break
        }
    }
    println(output)
}