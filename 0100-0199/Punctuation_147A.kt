fun main() {
    val reader = System.`in`.bufferedReader()
    val printer = System.out.bufferedWriter()
    val s = reader.readLine().trim()
    var t = ""
    var w = ""
    for (p in s.indices){
        if (s[p] in 'a'..'z'){
            if (p > 0 && w.isEmpty()) {
                t += " "
            }
           w += s[p]
        }
        else if(s[p] == ' ') {
            t += w
            w = ""
        }
        else{
            t+=w
            w = ""
            t+= s[p]
        }
    }

    if (t.isEmpty() || t[t.length - 1] == ' '){
        t += w
    }
    else if (w.isNotEmpty()) {
        t += ' '
        t += w
    }

    printer.write(t)
    printer.newLine()
    reader.close()
    printer.flush()
    printer.close()
}