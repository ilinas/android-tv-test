package com.trifork.android.tv.test.androidtvtest;

import android.os.SystemClock;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v17.leanback.widget.RowHeaderView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
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

    public void testSlider() {

        onView(allOf(withText("HOME AUTOMATION"), instanceOf(RowHeaderView.class), isDescendantOfA(withId(R.id.browse_headers))))
                .perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));

        onView(withText("Heat"))
                .perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));

        SystemClock.sleep(800);

        onView(withId(R.id.device_control_slider))
                .perform(pressKey(KeyEvent.KEYCODE_DPAD_RIGHT))
                .check(matches(withProgressBetween(30, 60)));
    }

    public void testLightIsLightHeatIsHeat() {

        onView(allOf(withText("HOME AUTOMATION"), instanceOf(RowHeaderView.class), isDescendantOfA(withId(R.id.browse_headers))))
                .perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));

        onView(withText("Light")).perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withText("Light")).check(matches(isDisplayed())).perform(pressBack());

        onView(withText("Heat")).perform(click(), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withText("Heat")).check(matches(isDisplayed()));
    }

    public static Matcher<View> withProgressBetween(final int min, final int max) {
        return new BoundedMatcher<View, SeekBar>(SeekBar.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("with progress between: " + min + " and " + max);
            }

            @Override
            public boolean matchesSafely(SeekBar seekBar) {
                return seekBar.getProgress() >= min && seekBar.getProgress() <= max;
            }
        };
    }
}
