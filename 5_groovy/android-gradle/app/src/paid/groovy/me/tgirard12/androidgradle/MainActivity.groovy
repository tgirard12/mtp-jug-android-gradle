package me.tgirard12.androidgradle

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends ActionBarActivity {

    int nbClick = 0

    @Override
    void onCreate(Bundle savedInstanceState) {
        super.onCreate savedInstanceState
        setContentView R.layout.activity_main

        def textView = findViewById(R.id.textView) as TextView
        textView.text =
                """${getString(R.string.hello_world)}
   buildType:$BuildConfig.BUILD_TYPE
   Flavor:$BuildConfig.FLAVOR
   debug:$BuildConfig.DEBUG"""


        textView.onClickListener = {
            Toast.makeText(this, "Click $nbClick times", Toast.LENGTH_SHORT).show()
            nbClick++
        }
    }

    @Override
    boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        true
    }

    @Override
    boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (item.itemId == R.id.action_settings) {
            return true
        }
        super.onOptionsItemSelected(item)
    }
}
