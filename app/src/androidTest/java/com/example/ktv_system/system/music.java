package com.example.ktv_system.system;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class music {

    @Rule
    public ActivityScenarioRule<TestActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(TestActivity.class);

    @Test
    public void cancle() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(Matchers.allOf(ViewMatchers.withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        constraintLayout.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(1)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(3)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(4)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(6)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(8)
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
                allOf(withId(R.id.music_item), withContentDescription("点歌"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.diange_listview))
                .atPosition(3)
                .onChildView(withId(R.id.diange_listview_cancle))
                .perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.diange_listview_geming), withText("Down Bad "),
                        withParent(withParent(withId(R.id.diange_listview))),
                        isDisplayed()));
        textView.check(doesNotExist());
//；
    }

    @Test
    public void up() {
        DataInteraction constraintLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gequ_mingdan),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        constraintLayout.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(1)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(3)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(4)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(6)
                .onChildView(withId(R.id.gequ_liuxing_listview_diange))
                .perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.liuxing_listview))
                .atPosition(8)
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
                allOf(withId(R.id.music_item), withContentDescription("点歌"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bootomnav2),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        DataInteraction constraintLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.diange_listview),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)))
                .atPosition(2);
        constraintLayout3.perform(click());

        onData(anything())
                .inAdapterView(withId(R.id.diange_listview))
                .atPosition(3)
                .onChildView(withId(R.id.diange_listview_up))
                .perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.diange_listview_geming), withText("Down Bad "),
                        withParent(withParent(withId(R.id.diange_listview))),
                        isDisplayed()));
        textView.check(doesNotExist());
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
