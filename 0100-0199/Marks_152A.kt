fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    val (numStudents, numCourses) = reader.readLine().split("\\s+".toRegex()).map { it.toInt() }
    var maxGrade: Int
    var temp: Char
    val successful = BooleanArray(numStudents)
    val grades = IntArray(numStudents * numCourses)

    repeat(numStudents) { n ->
        val input = reader.readLine().trim()
        repeat(numCourses) { m ->
            temp = input[m]
            grades[n * numCourses + m] = temp - '0'
        }
    }
    repeat(numStudents) { n ->
        successful[n] = false
    }

    repeat(numCourses) { m ->
        maxGrade = 0
        repeat(numStudents) { n ->
            maxGrade = maxOf(maxGrade, grades[n * numCourses + m])
        }

        repeat(numStudents) { n ->
            if (grades[n * numCourses + m] == maxGrade) successful[n] = true
        }
    }

    var total = 0
    repeat(numStudents) { student ->
        total += if (successful[student]) 1 else 0
    }
    writer.write("$total\n")
    reader.close()
    writer.flush()
    writer.close()
}