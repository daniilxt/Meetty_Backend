package extensions

import java.util.*
import javax.servlet.http.HttpServletResponse

fun String.toEncryptedPassword(): String = Base64.getEncoder().encodeToString(this.toByteArray())

fun HttpServletResponse.sendApiError(
    message: String,
    contentType: String = "application/json",
    httpResponseCode: Int = HttpServletResponse.SC_UNAUTHORIZED
) {
    this.contentType = contentType
    this.status = httpResponseCode
    this.outputStream.println("{ \"error\": \"$message\" }")
}
