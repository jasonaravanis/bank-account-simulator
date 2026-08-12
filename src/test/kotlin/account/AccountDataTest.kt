package account

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class AccountDataTest {
    @Test
    fun `serialisation-parse round trips back to same value`() {
        val accountData = AccountData("mock", "123.50")
        val serialized = Json.encodeToString(accountData)
        val deserialized = Json.decodeFromString<AccountData>(serialized)
        assertEquals("""{"name":"mock","balance":"123.50"}""", serialized)
        assertEquals(accountData, deserialized)
    }

    @Test
    fun `toAccount converts balance string to BigDecimal`() {
        val account = AccountData("mock", "123.50").toAccount()
        assertEquals(account.getBalance(), BigDecimal("123.50"))
    }
}
