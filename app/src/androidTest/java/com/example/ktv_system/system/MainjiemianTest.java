package com.example.ktv_system.system;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
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
public class MainjiemianTest {

    @Rule
    public ActivityScenarioRule<TestActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(TestActivity.class);
    @Test
    public void sousuo_geming() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.sousuo),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("love story"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.sousuo_btn), withText("搜索"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.gequ_liuxing_listview_geming), withText("Love Story "),
                        withParent(withParent(withId(R.id.sousuo_lv))),
                        isDisplayed()));
        textView.check(matches(withText("Love Story ")));
    }

    @Test
    public void sousuo_gexing() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.sousuo),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("陈粒"), closeSoftKeyboard());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.sousuo_btn), withText("搜索"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.gequ_liuxing_listview_geshou), withText("����"),
                        withParent(withParent(withId(R.id.sousuo_lv))),
                        isDisplayed()));
        textView.check(matches(withText("陈粒")));
    }
    @Test
    public void gequ_fenlei() {
        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radiobutton1), withText("歌曲分类"),
                        childAtPosition(
                                allOf(withId(R.id.radiogroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.radiobutton1), withText("歌曲分类"),
                        withParent(allOf(withId(R.id.radiogroup),
                                withParent(IsInstanceOf.<View>instanceOf(ViewGroup.class)))),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));
    }

    @Test
    public void gequfenlei_liuxing() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(3);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));
    }
    @Test
    public void gequfenlei_minyao() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

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
    }
    @Test
    public void gequfenlei_oumei() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));
    }
    @Test
    public void gequfenlei_yaogun() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(1);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

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


    }
    @Test
    public void gexing_mingdan() {
        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radiobutton2), withText("歌星列表"),
                        childAtPosition(
                                allOf(withId(R.id.radiogroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction listView = onView(
                allOf(withId(R.id.gexing_mingdan),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(ViewGroup.class))),
                        isDisplayed()));
        listView.check(matches(isDisplayed()));
    }

    @Test
    public void gexing_shaoshuai() {
        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radiobutton2), withText("歌星列表"),
                        childAtPosition(
                                allOf(withId(R.id.radiogroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gexing_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)))
                .atPosition(1);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));
    }
    @Test
    public void gexing_Taylor() {
        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radiobutton2), withText("歌星列表"),
                        childAtPosition(
                                allOf(withId(R.id.radiogroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gexing_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                1)))
                .atPosition(0);
        constraintLayout.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        withParent(allOf(withId(androidx.appcompat.R.id.decor_content_parent),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)))),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));
    }

    @Test
    public void fadanmu() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fadanmu), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction videoView = onView(
                allOf(withId(R.id.shiping),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        videoView.check(matches(isDisplayed()));

    }

    @Test
    public void fazhufu() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.fazhufu), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction view = onView(
                allOf(withParent(allOf(withId(com.google.android.exoplayer2.ui.R.id.exo_content_frame),
                                withParent(allOf(withId(R.id.shipin), withContentDescription("Show player controls"))))),
                        isDisplayed()));
        view.check(matches(isDisplayed()));
    }


    @Test
    public void control() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.control_item), withContentDescription("遥控"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction viewGroup = onView(
                allOf(withParent(withParent(IsInstanceOf.<View>instanceOf(androidx.recyclerview.widget.RecyclerView.class))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));
    }
    @Test
    public void music() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.music_item), withContentDescription("点歌"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction listView = onView(
                allOf(withId(R.id.diange_listview),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        listView.check(matches(isDisplayed()));
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
