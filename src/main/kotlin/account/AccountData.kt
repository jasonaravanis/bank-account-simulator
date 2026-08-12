package account

import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class AccountData(
    val name: String,
    val balance: String,
)

fun AccountData.toAccount(): Account = Account(name = name, balance = BigDecimal(balance))

fun Account.toAccountData(): AccountData = AccountData(name = getName(), balance = getBalance().toPlainString())
