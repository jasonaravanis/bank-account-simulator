package account

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class AccountTest {
    @Test
    fun `withdraw reduces the balance`() {
        val account = Account(BigDecimal(100))
        account.withdraw(BigDecimal(30))
        assertEquals(BigDecimal(70), account.getBalance())
    }

    @Test
    fun `withdrawing more than the balance throws AccountException`() {
        val account = Account(BigDecimal(50))

        val exception =
            assertFailsWith<AccountException> {
                account.withdraw(BigDecimal(100))
            }

        assertEquals("Withdrawal amount cannot exceed current account balance!", exception.message)
    }
}
