package com.example.androidapplication;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void usernamecheck() {
        onView(withId(R.id.editUser)).perform(typeText("ben"));



        onView(withId(R.id.regester)).perform(scrollTo(),(click()));

        onView(allOf(withId(R.id.editUser),hasErrorText("Must have 6 characters")));

    }
    @Test
    public void fullnamecheck(){
        onView(withId(R.id.editUser)).perform(typeText("test206"));
        onView(withId(R.id.editTextName)).perform(typeText("john"));
        onView(withId(R.id.regester)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.editTextName), hasErrorText("Must have 8 characters")));

    }
    @Test
    public void emailcheck(){
        onView(withId(R.id.editUser)).perform(typeText("test206"));
        onView(withId(R.id.editTextName)).perform(typeText(" messi ronaldo"));
        onView(withId(R.id.editTextEmail)).perform(typeText("john.gmail"));
        onView(withId(R.id.regester)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.editTextEmail), hasErrorText("Email is inValid")));
    }
    @Test
    public void voidoccupation(){
        onView(withId(R.id.editUser)).perform(typeText("abetest"));
        onView(withId(R.id.editTextName)).perform(typeText("abenezer taddesse"));
        onView(withId(R.id.editTextEmail)).perform(typeText("abe@gmail.com"));

        onView(withId(R.id.password)).perform(typeText("password12"));
        onView(withId(R.id.datePickerButton)).perform(scrollTo(),(click()));

        onView(withClassName(Matchers.equalTo(android.widget.DatePicker.class.getName()))).perform(PickerActions.setDate(2002 , 2, 15));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.password)).perform(typeText("password123"));
        onView(withId(R.id.regester)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.occupationInput), hasErrorText("Cant leave this empty")));
    }
    @Test
    public void passwordcheck(){
        onView(withId(R.id.editUser)).perform(typeText("abetest"));
        onView(withId(R.id.editTextName)).perform(typeText("abenezer taddesse"));
        onView(withId(R.id.editTextEmail)).perform(typeText("abe@gmail.com"));

        onView(withId(R.id.password)).perform(typeText("pass"));

        onView(withId(R.id.regester)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.password), hasErrorText("Password must have 8 or more characters")));
    }


    @Test
    public void register(){
        onView(withId(R.id.editUser)).perform(typeText("abetest"));
        onView(withId(R.id.editTextName)).perform(typeText("abenezer taddesse"));
        onView(withId(R.id.editTextEmail)).perform(typeText("abe@gmail.com"));
        onView(withId(R.id.datePickerButton)).perform(scrollTo(),(click()));

        onView(withClassName(Matchers.equalTo(android.widget.DatePicker.class.getName()))).perform(PickerActions.setDate(2002 , 2, 15));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.mainDescription)).perform(typeText("i love soccer and playing games"));
        onView(withId(R.id.occupationInput)).perform(typeText("abe@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("password12"));
        onView(withId(R.id.regester)).perform(scrollTo(),(click()));


    }

    @Test
    public void testbirthdaterror(){
        onView(withId(R.id.editUser)).perform(typeText("abetest"));
        onView(withId(R.id.editTextName)).perform(typeText("abenezer taddesse"));
        onView(withId(R.id.editTextEmail)).perform(typeText("abe@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("password12"));
        onView(withId(R.id.regester)).perform(scrollTo(),(click()));
        onView(allOf(withId(R.id.description), hasErrorText("need birth date")));
    }
    @Test
    public void checkAge() {

        onView(withId(R.id.datePickerButton)).perform(scrollTo(),(click()));

        onView(withClassName(Matchers.equalTo(android.widget.DatePicker.class.getName()))).perform(PickerActions.setDate(2005 , 8, 11));
        onView(withText("OK")).perform(click());

        onView(allOf(withId(R.id.description), hasErrorText("you need to be 18 or older")));

    }


}