package account

import java.math.BigDecimal

class AccountException(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause)

class Account(
    private var name: String,
    private var balance: BigDecimal = BigDecimal.ZERO,
) {
    fun getName(): String = name

    fun getBalance(): BigDecimal = balance

    fun deposit(amount: BigDecimal) {
        if (amount < BigDecimal.ZERO) throw AccountException("Deposit amount must be greater than zero!")
        this.balance += amount
    }

    fun withdraw(amount: BigDecimal) {
        if (amount < BigDecimal.ZERO) throw AccountException("Withdrawal amount must be greater than zero!")
        if (balance < amount) throw AccountException("Withdrawal amount cannot exceed current account balance!")
        this.balance -= amount
    }
}
