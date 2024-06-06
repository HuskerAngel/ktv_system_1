package com.example.ktv_system.zxc;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.Root;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.ktv_system.R;
import com.example.ktv_system.TestActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ControlTest {

    @Rule
    public ActivityScenarioRule<TestActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(TestActivity.class);

    @Before
    public void setUp() {
        Espresso.registerIdlingResources(ToastIdlingResource.getIdlingResource());
    }

    @After
    public void tearDown() {
        Espresso.unregisterIdlingResources(ToastIdlingResource.getIdlingResource());
    }

    @Test
    public void weidiange(){
        ViewInteraction bottomNavigationItemView = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Espresso.onView(withText("为点歌"))
                    .inRoot(new ToastMatcher())
                    .check(matches(isDisplayed()));
            ToastIdlingResource.decrement();
        }, 3500);

    }
    @Test
    public void huantong_add() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.huantong_add), withText("."),
                        childAtPosition(
                                allOf(withId(R.id.linelayout1),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                4)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction progressBar = onView(
                allOf(withId(R.id.progress1),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));
    }

    @Test
    public void huatong_reduce() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.huantong_reduce), withText("."),
                        childAtPosition(
                                allOf(withId(R.id.linelayout1),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                4)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction progressBar = onView(
                allOf(withId(R.id.progress1),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));
    }

    @Test
    public void yingxiang_add() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.yinxiang_add), withText("."),
                        childAtPosition(
                                allOf(withId(R.id.linelayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                9)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction progressBar = onView(
                allOf(withId(R.id.progress2),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));
    }

    @Test
    public void yingxiang_reduce() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.yinxiang_reduce), withText("."),
                        childAtPosition(
                                allOf(withId(R.id.linelayout2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                9)),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction progressBar = onView(
                allOf(withId(R.id.progress2),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));
    }

    @Test
    public void yinxiao() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.yingxiaoqiehuan), withText("音效切换"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                10),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.yingxiaoqiehuan), withText("切换成功"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        toggleButton.check(matches(ViewMatchers.isChecked()));
    }
    @Test
    public void pingfen() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.pingfen), withText("评分开关"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                11),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.pingfen), withText("评分（开）"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        toggleButton.check(matches(ViewMatchers.isChecked()));
    }

    @Test
    public void hujiao() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.hujiao), withText("呼叫服务"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                12),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.hujiao), withText("呼叫成功"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        toggleButton.check(matches(ViewMatchers.isChecked()));
    }

    @Test
    public void dengguang() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.dengguang), withText("灯光模式"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                13),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.dengguang), withText("灯光（开）"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        toggleButton.check(matches(ViewMatchers.isChecked()));
    }

    @Test
    public void btn1() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(1);
        constraintLayout.perform(click());


        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(2)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.action_bar),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn1),
                        childAtPosition(
                                allOf(withId(R.id.ll1),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Espresso.onView(withText("已经切换为伴唱模式"))
                    .inRoot(new ToastMatcher())
                    .check(matches(isDisplayed()));

            ToastIdlingResource.decrement();
        }, 3500);
    }

    @Test
    public void btn2() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(1);
        constraintLayout.perform(click());


        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(2)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.action_bar),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());



        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn2),
                        childAtPosition(
                                allOf(withId(R.id.ll1),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction seekBar = onView(
                allOf(withId(R.id.seekbar),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        seekBar.check(doesNotExist());
    }
    @Test
    public void btn3() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        constraintLayout.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(2)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.action_bar),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.bnt3),
                        childAtPosition(
                                allOf(withId(R.id.ll3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                7)),
                                0),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction seekBar = onView(
                allOf(withId(R.id.seekbar),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        seekBar.check(matches(withProgressBarValue(0)));
    }

    @Test
    public void btn4() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        constraintLayout.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(2)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(androidx.appcompat.R.id.action_bar),
                                        childAtPosition(
                                                withId(androidx.appcompat.R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.btn4),
                        childAtPosition(
                                allOf(withId(R.id.ll3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                7)),
                                1),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.btn4),
                        withParent(allOf(withId(R.id.ll3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox.check(matches(isChecked()));
    }


    public static Matcher<View> withProgressBarValue(final int expectedValue) {
        return new BoundedMatcher<View, ProgressBar>(ProgressBar.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with progress bar value: " + expectedValue);
            }

            @Override
            protected boolean matchesSafely(ProgressBar progressBar) {
                return progressBar.getProgress() == expectedValue;
            }
        };
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    public class ToastMatcher extends TypeSafeMatcher<Root> {
        @Override
        public void describeTo(Description description) {
            description.appendText("is toast");
        }

        @Override
        protected boolean matchesSafely(Root root) {
            int type = root.getWindowLayoutParams().get().type;
            Log.d("ToastMatcher", "Root type: " + type);
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                IBinder windowToken = root.getDecorView().getWindowToken();
                IBinder appToken = root.getDecorView().getApplicationWindowToken();
                Log.d("ToastMatcher", "Window token: " + windowToken);
                Log.d("ToastMatcher", "App token: " + appToken);
                return windowToken == appToken;
            }
            return false;
        }
    }

    public static class ToastIdlingResource {
        private static final CountingIdlingResource countingIdlingResource =
                new CountingIdlingResource("ToastIdlingResource");

        public static void increment() {
            countingIdlingResource.increment();
        }

        public static void decrement() {
            if (!countingIdlingResource.isIdleNow()) {
                countingIdlingResource.decrement();
            }
        }

        public static CountingIdlingResource getIdlingResource() {
            return countingIdlingResource;
        }
    }
}
