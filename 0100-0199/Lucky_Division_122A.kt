import java.io.PrintWriter

class LuckyDivision (val number: Int) {
    private var out: PrintWriter = PrintWriter(System.out)
    fun solve(){
        val res = when {
            this.number % 4 == 0 || this.number % 7 == 0 || this.number % 44 == 0 || this.number % 47 == 0 || this.number % 74 == 0 || this.number % 77 == 0 || this.number % 444 == 0 || this.number % 447 == 0 || this.number % 474 == 0 || this.number % 477 == 0 || this.number % 744 == 0 || this.number % 747 == 0 || this.number % 774 == 0 || this.number % 777 == 0 -> "YES"
            else -> "NO"
        }
        out.println(res)
        out.flush()
        out.close()
    }

}

fun main() {
    val reader = System.`in`.bufferedReader()
    val number = reader.readLine().trim().toInt()
    val lu = ::LuckyDivision
    lu(number).solve()
}