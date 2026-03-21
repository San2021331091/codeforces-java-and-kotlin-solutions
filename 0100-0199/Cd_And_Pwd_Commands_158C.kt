class Directory{
    private var path = mutableListOf<String>()
    fun pwd(){
        print("/")
        for (k in path.indices){
            print(path[k]+"/")
        }
        println()
    }
    fun pop() = path.removeLast()
    fun add(newDir: String){
        when{
            newDir == ".." -> pop()
            else -> path.add(newDir)
        }
    }
    fun root() = path.clear()
}
fun main() {

    val numCommands = readln().toInt()
    val dir = Directory()
    repeat(numCommands){
        val command = readln()
        when{
            command == "pwd" -> dir.pwd()
            command[0] == 'c' && command[1] == 'd' ->{
               var c: Char
               var index = 3
                var newFolder = ""
                if (command[index] == '/'){
                    index++
                    dir.root()
                }
                while (index < command.length){
                    c = command[index++]
                    when{
                        c!= '/' -> newFolder += c
                        else -> {
                            dir.add(newFolder)
                            newFolder = ""
                        }
                    }
                }
               if (newFolder != "") dir.add(newFolder)
            }
        }
    }
}