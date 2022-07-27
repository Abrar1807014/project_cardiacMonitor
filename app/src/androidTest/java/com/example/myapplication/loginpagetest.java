package com.example.myapplication;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;

import androidx.core.content.ContextCompat;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class loginpagetest{

    @Rule
    public ActivityScenarioRule<login> activityRule =
            new ActivityScenarioRule<>(login.class);

    @Test
    public void testlogin()
    {
        onView(withText("Sign in")).check(matches(isDisplayed()));
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));
        onView(withId(R.id.imageView2)).check(matches(isDisplayed()));
        onView(withId(R.id.imageView3)).check(matches(isDisplayed()));
        onView(withText("Forgot Password?")).check(matches(isDisplayed()));
        onView(withText("OR SIGN IN WITH")).check(matches(isDisplayed()));
        onView(withId(R.id.username)).perform(ViewActions.typeText("admin"));
        onView(withId(R.id.password)).perform(ViewActions.typeText("admin"));
        onView(withId(R.id.button)).perform(click());

    }
}
