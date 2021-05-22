package com.example.androidapplication;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SecondActivityTest {
    @Rule
    public ActivityScenarioRule<SecondActivity> activityScenarioRule
            = new ActivityScenarioRule<>(SecondActivity.class);

    @Test
    public void profileNavCheck() {

        onView(withId(R.id.nav_profile)).perform( click());
        onView((withId(R.id.profileText))).check((matches(withText("Your Profile"))));
    }

    @Test
    public void checkNavSetting() {

        onView(withId(R.id.nav_setting)).perform( click());
        try {
            onView(withId(R.id.settingText)).check(matches(withText("Settings")));
        } catch (NoMatchingViewException e) {
            onView(withId(R.id.nav_setting)).perform( click());
            onView(withId(R.id.settingText)).check(matches(withText("Settings")));
        }
    }
    @Test
    public void checkNavMatch() {

        onView(withId(R.id.nav_matches)).perform( click());
        //onView((withId(R.id.m_app_bar))).check((matches(withText("me"))));
        try {
            onView(withId(R.id.m_app_bar)).check(matches(hasDescendant(withText("Your Matches"))));
        } catch (NoMatchingViewException e) {
            onView(withId(R.id.nav_matches)).perform( click());
            onView(withId(R.id.m_app_bar)).check(matches(hasDescendant(withText("Your Matches"))));
        }
    }

}