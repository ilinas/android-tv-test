package com.trifork.android.tv.test.androidtvtest;

import android.support.v17.leanback.widget.RowHeaderView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;

@LargeTest
public class HelloWorldEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public HelloWorldEspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testHeadlineExists() {
        onView(withText("Videos by Your Company")).check(matches(isDisplayed()));
    }

    public void testPreferences() {
        onView(withText("PREFERENCES"))
                .perform(click());
        onView(withText("Error Fragment"))
                .check(matches(isDisplayed()));

        //onData(allOf(is(instanceOf(String.class)), is("Category Five"))).perform(click());

        //onView(withText("Studio Zero")).check(matches(isDisplayed()));
    }

    public void testToastDisplayed() {

        onView(allOf(withText("PREFERENCES"), instanceOf(RowHeaderView.class), isDescendantOfA(withId(R.id.browse_headers))))
                .perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));

        onView(withText("Personal Settings"))
                .perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));

        onView(withText("Personal Settings"))
                .inRoot(withDecorView(not(getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }
}