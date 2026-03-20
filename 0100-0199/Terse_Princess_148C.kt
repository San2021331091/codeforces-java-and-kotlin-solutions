fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    var (n,a,b) = reader.readLine().split("\\s+".toRegex()).map { it.toLong() }
    val v = MutableList(n.toInt()) { 1L }
    var current = 1L
    var sum = 1L
    for (p in 1 until n){
        if (b > 0){
            current = sum + 1
            --b
        }
        else if((p>1) && (a>0)) {
            ++current
            --a
        }
        v[p.toInt()] = current
        sum += current
    }
    when{
        ((a>0) || (b>0)) -> printer.write("-1\n")
        else->{
            for (p in 0 until n.toInt()){
                printer.write("${v[p]} ")
            }
        }
    }
    reader.close()
    printer.flush()
    printer.close()
}