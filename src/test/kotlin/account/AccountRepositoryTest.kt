package account

import java.io.File
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class AccountRepositoryTest {
    @Test
    fun `loadAccounts returns empty list when file does not exist`() {
        val repository = AccountRepository(File("/nonexistent/accounts.json"))
        assertEquals(emptyList(), repository.loadAccounts())
    }

    @Test
    fun `save then load returns the same accounts`() {
        val file = File.createTempFile("accounts", ".json")
        val repository = AccountRepository(file)

        repository.saveAccounts(listOf(Account("mock", BigDecimal("123.50"))))
        val loaded = repository.loadAccounts()

        assertEquals(listOf("mock"), loaded.map { it.getName() })
        assertEquals(listOf(BigDecimal("123.50")), loaded.map { it.getBalance() })
    }
}
