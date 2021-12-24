package regex

object RegexUtils {
    // language=RegExp
    private const val REG_EMAIL = "^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,6})\$"

    @JvmStatic
    fun checkEmailIsValid(text: String): Boolean {
        return Regex(REG_EMAIL).matches(text)
    }

}