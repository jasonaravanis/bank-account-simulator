package ui

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
}
