package extensions

import java.util.*

fun String.toEncryptedPassword(): String = Base64.getEncoder().encodeToString(this.toByteArray())