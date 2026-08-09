package account

import org.junit.jupiter.api.Nested
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AccountTest {
    @Nested
    inner class GetBalance {
        @Test
        fun `gets the account balance`() {
            val account = Account(BigDecimal(100))
            assertEquals(account.getBalance(), BigDecimal(100))
        }
    }

    @Nested
    inner class Deposit {
        @Test
        fun `increases the balance`() {
            val account = Account(BigDecimal(100))
            account.deposit(BigDecimal(30))
            assertEquals(account.getBalance(), BigDecimal(130))
        }

        @Test
        fun `throws Account Exception when deposit amount is less than 0`() {
            val account = Account(BigDecimal(100))
            val exception = assertFailsWith<AccountException> { account.deposit(BigDecimal(-30)) }

            assertEquals("Deposit amount must be greater than zero!", exception.message)
        }
    }

    @Nested
    inner class Withdraw {
        @Test
        fun `reduces the balance`() {
            val account = Account(BigDecimal(100))
            account.withdraw(BigDecimal(30))
            assertEquals(BigDecimal(70), account.getBalance())
        }

        @Test
        fun `throws AccountException when withdrawing more than the balance`() {
            val account = Account(BigDecimal(50))

            val exception =
                assertFailsWith<AccountException> {
                    account.withdraw(BigDecimal(100))
                }

            assertEquals("Withdrawal amount cannot exceed current account balance!", exception.message)
        }

        @Test
        fun `throws AccountException when withdrawal amount is less than zero`() {
            val account = Account(BigDecimal(100))

            val exception =
                assertFailsWith<AccountException> {
                    account.withdraw(BigDecimal(-50))
                }

            assertEquals("Withdrawal amount must be greater than zero!", exception.message)
        }
    }
}
