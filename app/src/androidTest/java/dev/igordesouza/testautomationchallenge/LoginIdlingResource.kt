package dev.igordesouza.testautomationchallenge

import androidx.test.espresso.idling.CountingIdlingResource

object LoginIdlingResource {

    val resource = CountingIdlingResource("LoginIdlingResource")

    suspend fun <T> track(
        block: suspend () -> T
    ): T {
        resource.increment()
        return try {
            block()
        } finally {
            if (!resource.isIdleNow) {
                resource.decrement()
            }
        }
    }
}
