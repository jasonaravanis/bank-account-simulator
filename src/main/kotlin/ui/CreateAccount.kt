package ui

import account.Account
import account.AccountRepository
import java.math.BigDecimal

fun parseAccountName(input: String): String? = input.trim().takeIf { it.isNotEmpty() }

fun parseInitialBalance(input: String): BigDecimal? =
    input
        .toBigDecimalOrNull()
        ?.takeIf { it >= BigDecimal.ZERO }

fun buildAccount(
    name: String,
    balance: BigDecimal,
): Account = Account(name, balance)

fun createAccount(repository: AccountRepository) {
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

    val newAccount = buildAccount(accountName, initialBalance)
    persistNewAccount(repository, newAccount)
}

fun persistNewAccount(
    repository: AccountRepository,
    newAccount: Account,
) {
    val accounts = repository.loadAccounts().toMutableList()
    accounts.add(newAccount)
    repository.saveAccounts(accounts)
}
