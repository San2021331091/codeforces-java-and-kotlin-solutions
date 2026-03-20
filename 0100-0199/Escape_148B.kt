import java.io.BufferedWriter

private fun interface Escape{
    fun solve(a: Double, b: Double,c: Double,d: Double,e: Double): Long
}

private fun BufferedWriter.writeLn(value: Long){
    this.write("$value\n")
}

fun main() {

    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val inp = List(5){reader.readLine().trim() }
    val (s,t,u,v,w) = inp
    val es = Escape{
        vp: Double, vd: Double, t: Double,f: Double,c: Double ->
        var bijous = 0L

        if (vp < vd){
            var distance: Double
            distance = vd * vp * t / (vd - vp)
            while (distance<c){
                distance = vd * (distance + vp * (f + distance/vd))/(vd-vp)
                ++bijous
            }
        }

        bijous
    }

    val bijous = es.solve(s.toDouble(),t.toDouble(),u.toDouble(),v.toDouble(),w.toDouble())
    writer.writeLn(bijous)
    reader.close()
    writer.flush()
    writer.close()

}