package me.tgirard12.androidgradle;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

/**
 * Created by tgirard on 09/03/15
 */
public class MainActivityFreeTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private TextView textView;

    public MainActivityFreeTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity(); // get a references to the app under test
        textView = (TextView) mActivity.findViewById(R.id.textView);
    }

    public void testTextView() {

        final String s = textView.getText().toString();
        assertEquals("Hello Debug world!" +
                "\n   buildType:debug" +
                "\n   Flavor:free" +
                "\n   debug:true",
                s);
    }
}
