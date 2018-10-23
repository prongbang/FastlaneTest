package com.touchtechnologies.fastlanetest;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.touchtechnologies.fastlanetest.utils.StringUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;
import tools.fastlane.screengrab.locale.LocaleUtil;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by mdev on 1/9/2018 AD.
 * Run Espresso:
 *      ./gradlew :App:connectedAndroidTest
 * Run Espresso for Fastlane:
 * Step 1.
 *      ./gradlew assembleDebug assembleAndroidTest
 * Step 2.
 *      fastlane screengrab
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RevertTextBehaviorTest {

    @ClassRule
    public static final LocaleTestRule mLocalTestRole = new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        LocaleUtil.changeDeviceLocaleTo(LocaleUtil.getTestLocale());
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
    }

    @After
    public void tearDown() throws Exception {
        LocaleUtil.changeDeviceLocaleTo(LocaleUtil.getEndingLocale());
    }

    @Test
    public void testShowOutput() {
        Screengrab.screenshot("screenshot_01");

        onView(withId(R.id.etMessage)).perform(typeText("Hello UI Testing"));
        Screengrab.screenshot("screenshot_02");

        onView(withId(R.id.btnRevert)).perform(click());
        Screengrab.screenshot("screenshot_03");

        onView(withId(R.id.tvOutput)).check(matches(withText(StringUtil.revert("Hello UI Testing"))));
        Screengrab.screenshot("screenshot_04");
    }
}
