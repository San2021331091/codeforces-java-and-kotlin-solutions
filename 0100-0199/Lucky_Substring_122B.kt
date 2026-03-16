fun main() {

    val input = readln()
    var fours = 0
    var sevens = 0

    for (k in input.indices){
        if (input[k] == '4') ++fours
        else if(input[k] == '7') ++sevens
    }
    val res = when {
        fours == 0 && sevens == 0 -> "-1"
        fours >= sevens -> "4"
        else -> "7"
    }
    println(res)

}