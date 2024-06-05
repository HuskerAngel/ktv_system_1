package com.example.ktv_system;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.Root;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class order_gequ {

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
    public void order_gequ() {
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


        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Espresso.onView(withText("提交成功"))
                    .inRoot(new ToastMatcher())
                    .check(matches(isDisplayed()));

            ToastIdlingResource.decrement();
        }, 3500);

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
