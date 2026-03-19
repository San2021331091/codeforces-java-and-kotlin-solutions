fun main() {
    val input = readln()
    var output = "."
    val commaPos = input.indexOf(".")
    var startInt: Int
    when {
        commaPos == -1 -> {
            startInt = input.length - 1
            output += "00"
        }
        else -> {
            startInt = commaPos - 1
            if (input.length >= commaPos + 2) {
                output += input[commaPos + 1] }
            output += if (input.length >= commaPos + 3) {
                input[commaPos + 2]
            } else {
                '0'
            }
        }
    }
    for (p in startInt downTo 1){
        output = input[p] + output
        if((startInt - p) % 3 == 2){
            output = ",$output"
        }
    }

    when{
        input[0] == '-'->{
            when{
                output[0]==','->{
                    output = "$" + output.substring(1)
                    output = "($output"
                }
                else ->{
                    output = "($$output"
                }
            }
            output += ")"
        }
        else -> {
            output = input[0] + output
            output = "$$output"
        }
    }
    println(output)
}


