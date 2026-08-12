package ui

import account.Account
import account.AccountRepository
import java.io.File
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.jupiter.api.Nested

class CreateAccountKtTest {

    @Nested
    inner class ParseAccountName {
        @Test
        fun `returns null for empty input`() {
            assertNull(parseAccountName(""))
        }

        @Test
        fun `returns null for whitespace-only input`() {
            assertNull(parseAccountName("   "))
        }

        @Test
        fun `returns trimmed name for valid input`() {
            assertEquals("Savings", parseAccountName("  Savings  "))
        }
    }

    @Nested
    inner class ParseInitialBalance {
        @Test
        fun `returns null for non-numeric input`() {
            assertNull(parseInitialBalance("abc"))
        }

        @Test
        fun `returns null for negative balance`() {
            assertNull(parseInitialBalance("-5"))
        }

        @Test
        fun `parses valid balance`() {
            assertEquals(BigDecimal("10.50"), parseInitialBalance("10.50"))
        }
    }

    @Nested
    inner class PersistNewAccount {
        @Test
        fun `saves the new account to the repository`() {
            val file = File.createTempFile("accounts", ".json")
            val repository = AccountRepository(file)
            val account = Account("Savings", BigDecimal("100"))

            persistNewAccount(repository, account)

            val loaded = repository.loadAccounts()
            assertEquals(listOf("Savings"), loaded.map { it.getName() })
            assertEquals(listOf(BigDecimal("100")), loaded.map { it.getBalance() })
        }

        @Test
        fun `appends to existing accounts instead of overwriting`() {
            val file = File.createTempFile("accounts", ".json")
            val repository = AccountRepository(file)
            repository.saveAccounts(listOf(Account("Checking", BigDecimal("50"))))

            persistNewAccount(repository, Account("Savings", BigDecimal("100")))

            val loaded = repository.loadAccounts()
            assertEquals(
                listOf("Checking", "Savings"),
                loaded.map { it.getName() },
            )
        }
    }
}
