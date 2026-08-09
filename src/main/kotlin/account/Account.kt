package account

import java.math.BigDecimal

class AccountException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)

class Account(
    private var balance: BigDecimal = BigDecimal.ZERO,
) {
    fun getBalance(): BigDecimal = balance

    fun withdraw(amount: BigDecimal) {
        val newBalance = balance - amount
        if (newBalance < BigDecimal.ZERO) throw AccountException("Withdrawal amount cannot exceed current account balance!")
        this.balance = newBalance
    }
}
