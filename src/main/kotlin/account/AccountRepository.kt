package account

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class AccountRepository(
    private val file: File,
) {
    fun loadAccounts(): List<Account> {
        if (!file.exists()) return emptyList()
        val json = file.readText()
        val data = Json.decodeFromString<List<AccountData>>(json)
        return data.map { it.toAccount() }
    }

    fun saveAccounts(accounts: List<Account>) {
        val data = accounts.map { it.toAccountData() }
        val json = Json.encodeToString(data)
        file.writeText(json)
    }
}
