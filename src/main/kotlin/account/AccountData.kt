package account

import kotlinx.serialization.Serializable

@Serializable
data class AccountData(
    val name: String,
    val balance: String,
)
