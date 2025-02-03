import kotlin.system.exitProcess

open class Utility {
    companion object {
        fun showMenu() {
            println("1. Add Task")
            println("2. View Tasks")
            println("3. Mark Task as Completed")
            println("4. Remove Task")
            println("5. Exit")
        }

        fun addTask(tasks: MutableList<String>) {
            print("Enter the task title: ")
            tasks.add(readln())
        }

        fun viewAllTasks(tasks: MutableList<String>) {
            var index = 1
            println("---------------------")
            println("|        Tasks       |")
            println("---------------------")
            tasks.stream().forEach { task ->
                run {
                    println("$index. $task")
                    index++
                }
            }
            println("---------------------")
        }

        fun markTaskAsCompleted(tasks: MutableList<String>) {
            viewAllTasks(tasks)
            print("Enter the task index to mark as completed: ")
            val indexOfTask = readln().toInt()
            if (indexOfTask > 0 && indexOfTask <= tasks.size) {
                tasks[indexOfTask - 1] = "[Completed] ${tasks[indexOfTask - 1]}"
            } else {
                println("Invalid task index. Please enter a valid task index.")
            }
        }

        fun removeTask(tasks: MutableList<String>) {
            viewAllTasks(tasks)
            print("Enter the task index to remove: ")
            tasks.removeAt(readln().toInt() - 1)
        }

        fun exitApplication() {
            println("Exiting..... Goodbye!")
            exitProcess(0)
        }
    }
}

fun main() {
    val tasks = mutableListOf<String>()
    var answer: Int
    println("Welcome to the Task Manager!")

    do {
        Utility.showMenu()
        print("Enter your choice: ")
        answer = readln().toInt()
        when (answer) {
            1 -> Utility.addTask(tasks)
            2 -> Utility.viewAllTasks(tasks)
            3 -> Utility.markTaskAsCompleted(tasks)
            4 -> Utility.removeTask(tasks)
            5 -> Utility.exitApplication()
            else -> println("Invalid Choice. Please enter a valid choice.")
        }
    } while (answer != 5)
}


