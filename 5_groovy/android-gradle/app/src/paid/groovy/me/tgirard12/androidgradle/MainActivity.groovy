package me.tgirard12.androidgradle

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Base64
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.TextView
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
            Fluent.async {
                def content = new URL("http://www.jug-montpellier.org/public/images/logo.png").getBytes()
                Base64.encodeToString(content, 0)
            } then {
                def webView = findViewById(R.id.webView) as WebView
                webView.loadData(""" <img src="data:image/png;base64,$it" width="100px" height="80px"/> """, 'text/html', 'utf-8')
            }
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
