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
public class data_addUitest {
    @Rule
    public ActivityScenarioRule<DataAdd> activityRule =
            new ActivityScenarioRule<>(DataAdd.class);

    @Test
    public void testdataadd() {
  //      onView(withText("Date")).check(matches(isDisplayed()));
//        onView(withText("Time")).check(matches(isDisplayed()));
        onView(withId(R.id.etFirstName)).perform(ViewActions.typeText("120"));
       onView(withId(R.id.etLastName)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.etFavFood)).perform(ViewActions.typeText("60"));
        onView(withId(R.id.submit)).perform(click());

    }

}
