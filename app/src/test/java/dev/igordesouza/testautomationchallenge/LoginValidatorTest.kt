package dev.igordesouza.testautomationchallenge

import org.junit.Test

import org.junit.Assert.*

class LoginValidatorTest {

    //Improvements: readability, add BDD DSL

    @Test
    fun givenValidCorrectCredentials_Login_Then_Succeds() {
        val result = LoginValidator.isValid("user", "pass")
        assertTrue(result)
    }

    @Test
    fun givenValidButIncorrectUsername_Login_Then_Fails() {
        val result = LoginValidator.isValid("user1", "pass")
        assertFalse(result)
    }

    @Test
    fun givenValidButIncorrectPassword_Login_Then_Fails() {
        val result = LoginValidator.isValid("user", "pas")
        assertFalse(result)
    }

    @Test
    fun givenCorrectButWithSpacePassword_Login_Then_Succeds() {
        val result = LoginValidator.isValid("user", " pass ")
        assertTrue(result)
    }

    @Test
    fun givenCorrectButWithSpaceUsername_Login_Then_Succeds() {
        val result = LoginValidator.isValid(" user ", "pass")
        assertTrue(result)
    }

    @Test
    fun givenBothParametersWithSpace_Login_Then_Succeds() {
        val result = LoginValidator.isValid(" user ", "pass ")
        assertTrue(result)
    }

}