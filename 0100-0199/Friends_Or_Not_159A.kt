import java.util.*

private data class IPairT<T, F>(val first: T, val second: F) :
    Comparable<IPairT<T, F>> where T : Comparable<T>, F : Comparable<F> {
    override fun compareTo(other: IPairT<T, F>): Int {
        val cmp = this.first.compareTo(other.first)
        return if (cmp != 0) cmp else this.second.compareTo(other.second)
    }
}

private fun <T> treeSetOf(): TreeSet<T> {
    return TreeSet<T>()
}

fun main() {

    val reader = System.`in`.bufferedReader()
    val (n, d) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }.toIntArray()
    val printer = System.out.bufferedWriter()
    val people = mutableListOf<IPairT<String, String>>()
    val times = mutableListOf<Int>()
    val friends = treeSetOf<IPairT<String, String>>()
    val input = generateSequence { reader.readLine() }.filter { it.isNotBlank() }.flatMap { it.split(" ").asSequence() }.iterator()
    repeat(n) {
        val source = input.next()
        val dest = input.next()
        val messageTime = input.next().toInt()
        val messagePeople = IPairT(source, dest)
        people.add(messagePeople)
        times.add(messageTime)
    }
    for (before in 0 until n) {
        val sourceBefore = people[before].first
        val destBefore = people[before].second
        val timeBefore = times[before]

        for (after in before + 1 until n) {
            val sourceAfter = people[after].first
            val destAfter = people[after].second
            val timeAfter = times[after]
            if (timeAfter > timeBefore && timeAfter - timeBefore <= d && sourceBefore == destAfter && destBefore == sourceAfter) {
                if (!friends.contains(IPairT(sourceBefore, destBefore)) && !friends.contains(
                        IPairT(
                            destBefore,
                            sourceBefore
                        )
                    )
                ) {
                    friends.add(IPairT(sourceBefore, destBefore))
                }
            }

        }
    }

    printer.write("${friends.size}\n")
    val iterator = friends.iterator()
    while (iterator.hasNext()){
        val it = iterator.next()
        printer.write("${it.first} ${it.second}\n")
    }
    reader.close()
    printer.flush()
    printer.close()

}