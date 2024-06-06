package com.example.ktv_system.zjl;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.ktv_system.R;
import com.example.ktv_system.TestActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FadanmuTest {

    @Rule
    public ActivityScenarioRule<TestActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(TestActivity.class);

    @Test
    public void fadanmuTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));
    }
    @Test
    public void testActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.fadanmu_btn1), withText("赞"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatToggleButton.perform(click());


        ViewInteraction editText = onView(
                allOf(withId(R.id.fandanmu_et), withText("狂击6666"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("狂击6666")));
    }
    @Test
    public void fadanmu_btn2Test() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.fandanmu_btn2), withText("踩"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                2),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.fandanmu_btn2), withText("踩"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(ViewGroup.class))),
                        isDisplayed()));
        toggleButton.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.fandanmu_et), withText("听你的歌，真的需要勇气"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("听你的歌，真的需要勇气")));
    }
    @Test
    public void fadanmu_btn3Test() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.fandanmu_btn3), withText("彩虹屁"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                3),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.fandanmu_btn3), withText("彩虹屁"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(ViewGroup.class))),
                        isDisplayed()));
        toggleButton.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.fandanmu_et), withText("有毛病呀，唱这么好听干嘛"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("有毛病呀，唱这么好听干嘛")));
    }
    @Test
    public void fadanmu_btn4Test() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.fandanmu_btn4), withText("生日聚会"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                4),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction toggleButton = onView(
                allOf(withId(R.id.fandanmu_btn4), withText("生日聚会"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(ViewGroup.class))),
                        isDisplayed()));
        toggleButton.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.fandanmu_et), withText("想要的都拥有，得不到的都释怀。生日快乐"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("想要的都拥有，得不到的都释怀。生日快乐")));
    }
    @Test
    public void fadanmu_fasongTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.fadanmu_btn1), withText("赞"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        4),
                                1),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.fadanmu_fason), withText("马上发射"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.duihuakuang), withText("发送成功"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView.check(matches(withText("发送成功")));
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
}
