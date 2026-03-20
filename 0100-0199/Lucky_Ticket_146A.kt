fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val n = reader.readLine().trim().toInt()
    val number = reader.readLine().trim()
    var output = "YES"
    var firstSum = 0
    var secondSum = 0
    for (k in 0 until n/2){
        when{
            number[k]!='4' && number[k]!='7' ->{
                output = "NO"
                break
            }
            number[n/2 + k] != '4' && number[n/2 + k] != '7' ->{
                output = "NO"
                break
            }

        }
        firstSum += number[k] - '0'
        secondSum += number[n/2 + k] - '0'
    }
    if (firstSum!=secondSum) output = "NO"
    printer.write(output+"\n")
    reader.close()
    printer.flush()
    printer.close()
}