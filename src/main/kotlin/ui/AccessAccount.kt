package ui

import account.Account
import account.AccountRepository

fun parseAccountIndex(
    accounts: List<Account>,
    input: String,
): Int? = input.toIntOrNull()?.takeIf { it in 1..accounts.size }?.minus(1)

fun accessAccount(repository: AccountRepository): Account? {
    val accounts = repository.loadAccounts()
    if (accounts.isEmpty()) {
        println("No accounts found.")
        return null
    }

    accounts.forEachIndexed { index, account ->
        println("${index + 1}. ${account.getName()}")
    }

    var selected: Account? = null
    while (selected == null) {
        print("Choose an account: ")
        selected = parseAccountIndex(accounts, readln())?.let { accounts[it] } ?: run {
            println("Invalid. Please try again.")
            null
        }
    }
    return selected
}
