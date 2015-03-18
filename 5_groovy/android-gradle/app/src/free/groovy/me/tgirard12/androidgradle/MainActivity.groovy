package me.tgirard12.androidgradle

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Base64
import android.webkit.WebView
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
                def content = new URL("http://www.jug-montpellier.org/public/images/logo.png").getBytes()
                Base64.encodeToString(content, 0)
            } then {
                def webView = findViewById(R.id.webView) as WebView
                webView.loadData(""" <img src="data:image/png;base64,$it" width="100px" height="80px"/> """, 'text/html', 'utf-8')
            }
        }
    }
}
