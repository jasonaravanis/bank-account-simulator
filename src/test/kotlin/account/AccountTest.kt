package account

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AccountTest {
    @Test
    fun `withdraw reduces the balance`() {
        val account = Account(BigDecimal(100))
        account.withdraw(BigDecimal(30))
        assertEquals(BigDecimal(70), account.getBalance())
    }
}
