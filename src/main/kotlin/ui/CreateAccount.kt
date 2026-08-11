package ui

import account.Account
import java.math.BigDecimal

fun parseAccountName(input: String): String? =
    input.trim().takeIf { it.isNotEmpty() }

fun parseInitialBalance(input: String): BigDecimal? =
    input.toBigDecimalOrNull()
        ?.takeIf { it >= BigDecimal.ZERO }

fun buildAccount(name: String, balance: BigDecimal): Account =
    Account(name, balance)

fun createAccount() {
    var accountName: String? = null
    while (accountName == null) {
        print("Name: ")
        accountName = parseAccountName(readln()) ?: run {
            println("Invalid. Please try again.")
            null
        }
    }

    var initialBalance: BigDecimal? = null
    while (initialBalance == null) {
        print("Initial balance: ")
        initialBalance = parseInitialBalance(readln()) ?: run {
            println("Invalid")
            null
        }
    }

    buildAccount(accountName, initialBalance)
}
