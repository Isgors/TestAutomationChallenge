package dev.igordesouza.testautomationchallenge

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class BaseIdlingTestRule(
    private vararg val idlingResources: IdlingResource
) : TestRule {

    override fun apply(
        base: Statement,
        description: Description
    ): Statement {
        return object : Statement() {
            override fun evaluate() {
                try {
                    registerIdlingResources()
                    base.evaluate()
                } finally {
                    unregisterIdlingResources()
                }
            }
        }
    }

    private fun registerIdlingResources() {
        idlingResources.forEach {
            IdlingRegistry.getInstance().register(it)
        }
    }

    private fun unregisterIdlingResources() {
        idlingResources.forEach {
            IdlingRegistry.getInstance().unregister(it)
        }
    }
}
