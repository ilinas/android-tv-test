package com.trifork.android.tv.test.androidtvtest;

import android.os.SystemClock;
import android.support.test.espresso.action.EspressoKey;
import android.support.test.espresso.action.KeyEventAction;
import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.Matchers.is;
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
        onView(withText("PREFERENCES"))
                .perform(pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_DPAD_DOWN),
                        pressKey(KeyEvent.KEYCODE_ENTER)
                        );

        onView(withText("Grid View"))
                .perform(pressKey(KeyEvent.KEYCODE_DPAD_RIGHT),
                        pressKey(KeyEvent.KEYCODE_DPAD_RIGHT),
                        pressKey(KeyEvent.KEYCODE_ENTER)
                );

        onView(withText("Personal Settings"))
                .inRoot(withDecorView(not(getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

        /*onView(withText("Personal Settings"))
                .perform(click());

        SystemClock.sleep(3000);

        onView(withText("Personal Settings"))
                .inRoot(withDecorView(not(getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));*/
    }
}