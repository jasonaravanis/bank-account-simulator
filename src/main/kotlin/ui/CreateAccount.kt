package ui

import account.Account
import java.math.BigDecimal

fun createAccount() {
    println("Provide a name for your new account.")

    var accountName: String? = null
    while (accountName == null) {
        print("Name: ")
        val accountNameInput = readln()
        if (accountNameInput.isEmpty()) {
            println("Invalid. Please try again.")
        } else {
            accountName = accountNameInput
        }
    }

    println("Your chosen account name is '$accountName'")
    println("What is the initial balance of your account?")
    var initialBalance: BigDecimal? = null
    while (initialBalance == null) {
        print("Initial balance: ")
        val initialBalanceInput = readln().toBigDecimalOrNull()
        when {
            (initialBalanceInput == null) -> println("Invalid")
            (initialBalanceInput < BigDecimal.ZERO) -> println("Invalid")
            else -> initialBalance = initialBalanceInput
        }
    }

    val newAccount = Account(accountName, initialBalance)
}
