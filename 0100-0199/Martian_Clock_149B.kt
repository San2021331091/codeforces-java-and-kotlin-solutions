import java.util.LinkedList
import java.util.Vector

private fun<T> Vector<T>.isUnitLength(): Boolean{
    return this.size == 1
}
fun main() {
    val time = readln()
    val hour = Vector<Int>()
    val minute = Vector<Int>()
    var flag = false
    var minBase = 2
    for (p in time.indices){
        var c = 0
        when {
            time[p] == ':' ->{
                flag = true
                continue
            }
            time[p] in '0'..'9' ->{
                c = time[p] - '0'
            }
            time[p] in 'A' .. 'Z' ->{
                c = 10 + (time[p] - 'A')
            }
        }
        when{
            !flag && (c > 0 || hour.isNotEmpty()) ->{
             hour.add(c)
            }
            flag && (c > 0 || minute.isNotEmpty()) ->{
                minute.add(c)
            }
        }
        if (c + 1 > minBase) minBase = c + 1
    }
    val ans = LinkedList<Int>()

    when{
        (hour.isEmpty() ||(hour.isUnitLength() && hour[0] < 24)) && (minute.isEmpty() || (minute.isUnitLength() && minute[0] < 60)) ->{
           println("-1")
        }
        else ->{
            for (b in minBase .. 60){
                var possible = true
                var m = 0
                for (q in minute.indices){
                    m = b * m + minute[q]
                    if (m >= 60)
                    {
                        possible = false
                        break
                    }
                }
                var h = 0
                for (q in hour.indices){
                    h = b * h + hour[q]
                    if (h >= 24){
                        possible = false
                        break
                    }
                }
                if (possible) ans.add(b)
            }
            when{
                ans.isEmpty() ->{
                    println("0")
                }
                else ->{
                    ans.forEach {
                        print("$it ")
                    }
                    println()
                }
            }
        }
    }
}