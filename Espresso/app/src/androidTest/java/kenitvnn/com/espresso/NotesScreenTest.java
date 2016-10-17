package kenitvnn.com.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
/**
 * Created by mryit on 10/17/2016.
 */
@RunWith(AndroidJUnit4.class)
public class NotesScreenTest {

    NotesActivity mActivity;

    @Rule
    public ActivityTestRule<NotesActivity> mNotesActivityActivityTest =
            new ActivityTestRule<NotesActivity>(NotesActivity.class);

    @Before
    public void setActivity() {
        mActivity = mNotesActivityActivityTest.getActivity();
        //ButterKnife.bind(this, mActivity);
    }


    @Test
    public void clickAddNoteButton_opensAddNoteUi () throws Exception {

        onView(withId(R.id.button_add_note))
                .perform(click());

        onView(withId(R.id.text_view_add_note_title))
                .check(matches(isDisplayed()));

    }

}
