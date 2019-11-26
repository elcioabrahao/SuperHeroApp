package com.trantordev.superheroapp.ui


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.trantordev.superheroapp.R
import com.trantordev.superheroapp.ui.SwipeRefreshLayoutMatchers.isRefreshing
import org.hamcrest.Matchers.allOf
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        onView(allOf(withId(R.id.textViewYear), withText("2006")))
        swipeAndWait()
        onView(allOf(withId(R.id.textViewYear), withText("2009")))
        swipeAndWait()
        onView(allOf(withId(R.id.textViewYear), withText("2012")))
        swipeAndWait()
        onView(allOf(withId(R.id.textViewYear), withText("2015")))
        swipeAndWait()
        onView(allOf(withId(R.id.textViewYear), withText("2018")))
        swipeAndWait()
        onView(allOf(withId(R.id.textViewYear), withText("2006")))
    }

    fun swipeAndWait(){
        Espresso.onView(ViewMatchers.withId(R.id.swipeContainer)).perform(ViewActions.swipeDown())
        onView(withId(R.id.swipeContainer)).check(matches(isRefreshing()))
        onView(isRoot()).perform(waitFor(5000))
    }
}
