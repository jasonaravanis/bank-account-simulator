package ui

import account.Account
import account.AccountRepository

fun accountActions(
    account: Account,
    repository: AccountRepository,
) {
    println("You selected: ${account.getName()}")
}
