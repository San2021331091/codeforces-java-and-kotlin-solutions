fun main() {
    val line = readln()
    var index = 0
    var numTrips = 0
    var additional: Int
    while (index < line.length){
        val target = line[index]
        additional = 1
        while(index + additional < line.length && additional <5 && line[index + additional] == target){++additional}
        index += additional
        ++numTrips
    }
    println(numTrips)
}
