package com.kirilcorp.cityview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kirilcorp.cityview", appContext.packageName)
    }

//    fun menuTest(){
//        onView(withId(R.id.fragmentSettingsHector))            // withId(R.id.my_view) is a ViewMatcher
//            .perform(click())               // click() is a ViewAction
//            .check(matches(isDisplayed()))  // matches(isDisplayed()) is a ViewAssertion
//    }
}