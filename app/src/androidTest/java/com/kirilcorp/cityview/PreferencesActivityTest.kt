package com.kirilcorp.cityview


import android.view.View
import android.view.ViewGroup
import androidx.preference.SwitchPreferenceCompat
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.isA
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class PreferencesActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun preferencesActivityTest() {
        val imageView = onView(
            allOf(
                withContentDescription("More options"),
                withParent(withParent(withId(R.id.action_bar))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val overflowMenuButton = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.action_bar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.title), withText("Preferences"),
                withParent(withParent(withId(R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Preferences")))

        val appCompatTextView = onView(
            allOf(
                withId(R.id.title), withText("Preferences"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        onView(withText("Enable notifications"))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withText("Activate sound"))
            .check(matches(isDisplayed()))
            .perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
