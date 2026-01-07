package dev.igordesouza.testautomationchallenge

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Mock test class for Task 3
 */
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {


    @Test
    fun invalidLoginShowsError(){
        onView(withId(R.id.username)).perform(typeText("bad"))
        onView(withId(R.id.password)).perform(typeText("creds"))
        onView(withId(R.id.login)).perform(click())
        onView(withId(R.id.error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    /**
     * Task 4
     * What you test at unit vs UI level.
     * At Unit level we test the classes that are the core of the code.
     * They can or cannot be dependant of the specific platform(Android/iOS)
     * Usually unit tests are made for classes like the ViewModel, Repository, Usecases and many more.
     * At UI level we use Espresso(For view-based screen), ComposeTest(for JetpackCompose Screen) or UiAtoumator for SystemLevel Assertions(like permission dialogs, browser assertions etc.)
     * Flaky test are avoid having in place JUnit Rules that use test categories with an specific duration so we can determine if a test is flaky.
     * Then we treat the flaky tests like automation bugs and isolate them (or quarantine) until they are stable.
     * Flakiness can happen due to wrong assertions, device specific OS, and many more.
     *
     */

}