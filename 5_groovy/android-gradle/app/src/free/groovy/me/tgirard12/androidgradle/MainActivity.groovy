package me.tgirard12.androidgradle

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
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
}
