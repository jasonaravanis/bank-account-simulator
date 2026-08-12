package ui

import account.Account
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class AccessAccountKtTest {

    private val accounts = listOf(
        Account("Savings"),
        Account("Checking"),
    )

    @Nested
    inner class ParseAccountIndex {
        @Test
        fun `returns null for non-numeric input`() {
            assertNull(parseAccountIndex(accounts, "abc"))
        }

        @Test
        fun `returns null for out-of-range input`() {
            assertNull(parseAccountIndex(accounts, "3"))
        }

        @Test
        fun `returns null for zero`() {
            assertNull(parseAccountIndex(accounts, "0"))
        }

        @Test
        fun `returns zero-based index for valid selection`() {
            assertEquals(0, parseAccountIndex(accounts, "1"))
            assertEquals(1, parseAccountIndex(accounts, "2"))
        }
    }
}
