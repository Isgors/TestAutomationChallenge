package dev.igordesouza.testautomationchallenge

object LoginValidator {

    fun isValid(userName: String, password: String): Boolean {

        val validatedUserName = validateUserName(userName)
        val validatedPassword = validatePassword(password)

        return validatedUserName == "user" && validatedPassword == "pass"
    }

    private fun validateUserName(userName: String): String {
        val validatedUserName = userName.trim()

        if (validatedUserName.isEmpty()) {
            throw IllegalArgumentException("Username cannot be empty")
        }

        return validatedUserName
    }

    private fun validatePassword(password: String): String {
        val validatedPassword = password.trim()

        if (validatedPassword.isEmpty()) {
            throw IllegalArgumentException("Username cannot be empty")
        }

        return validatedPassword
    }

}