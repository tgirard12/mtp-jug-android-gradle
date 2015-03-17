package me.tgirard12.androidgradle

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.widget.TextView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends ActionBarActivity {

    Integer nbClick = 0

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
            Fluent.async {
                new URL("http://api.openweathermap.org/data/2.5/weather?q=Montpellier,fr").readLines()
            } then {
                textView.text = (it[0])
            }
        }
    }
}
