

enum class Action {
    ACCESS_ACCOUNT,
    CREATE_ACCOUNT,
}

fun main() {
    println("What do you want to do? Please enter '1' or '2'")
    println("1. Access an existing account")
    println("2. Create a new account")
    print("Choice: ")

    var userChoice: Action? = null
    while (userChoice === null) {
        val input = readln().toIntOrNull()
        when (input) {
            1 -> userChoice = Action.ACCESS_ACCOUNT
            2 -> userChoice = Action.CREATE_ACCOUNT
        }
    }

    println(userChoice)
}
