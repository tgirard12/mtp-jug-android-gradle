package me.tgirard12.androidgradle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(
                getString(R.string.hello_world) +
                        "\n   buildType:" + BuildConfig.BUILD_TYPE +
                        "\n   Flavor:" + BuildConfig.FLAVOR +
                        "\n   debug:" + BuildConfig.DEBUG);
    }
}
