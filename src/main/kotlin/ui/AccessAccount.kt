package ui

import account.AccountRepository

fun accessAccount(repository: AccountRepository) {
    val accounts = repository.loadAccounts()
    accounts.forEach { println(it) }
}
