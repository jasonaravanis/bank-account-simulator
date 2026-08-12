import account.AccountRepository
import ui.accessAccount
import ui.accountActions
import ui.createAccount
import java.io.File

enum class Action {
    ACCESS_ACCOUNT,
    CREATE_ACCOUNT,
    QUIT,
}

fun main() {
    val accountRepository = AccountRepository(File("accounts.json"))

    println("What do you want to do? Please enter '1' or '2' or '3'")
    println("1. Access an existing account")
    println("2. Create a new account")
    println("3. Quit")
    print("Choice: ")

    var userChoice: Action? = null
    while (userChoice === null) {
        val input = readln().toIntOrNull()
        when (input) {
            1 -> userChoice = Action.ACCESS_ACCOUNT
            2 -> userChoice = Action.CREATE_ACCOUNT
            3 -> userChoice = Action.QUIT
            else -> println("Invalid option, try again.\n")
        }
    }

    when (userChoice) {
        Action.ACCESS_ACCOUNT -> accessAccount(accountRepository)?.let { accountActions(it, accountRepository) }
        Action.CREATE_ACCOUNT -> createAccount(accountRepository)
        Action.QUIT -> return
    }
}
