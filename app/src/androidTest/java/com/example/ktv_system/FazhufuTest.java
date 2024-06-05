package com.example.ktv_system;


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

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FazhufuTest {

    @Rule
    public ActivityScenarioRule<TestActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(TestActivity.class);


    @Test
    public void fazhufu_btn1() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.btn1), withText("OFF"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.fabianzhufu), withText("祝你生日快乐"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("祝你生日快乐")));
    }

    @Test
    public void fazhufu_btn2() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.btn2), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.fabianzhufu), withText("愿我们的友情地久天长"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("愿我们的友情地久天长")));
    }

    @Test
    public void fazhufu_btn3() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.btn3), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.fabianzhufu), withText("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路")));
    }

    @Test
    public void fazhufu_btn4() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.btn4), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.fabianzhufu), withText("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        editText.check(matches(withText("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升")));
    }

    @Test
    public void fason() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatToggleButton = onView(
                allOf(withId(R.id.btn3), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatToggleButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.fazhufu_fason), withText("发表"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                15),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.duihuakuang), withText("发送成功"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));
    }


    @Test
    public void tupian() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());




        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.upload),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                14),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.fanzhufu_image),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
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
