package com.github.sungminpark.android.kitchenSink

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import org.jetbrains.anko.button
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            listOf(
                    "App Bar" to { startActivity<AppBarActivity>() },
                    "App Bar Up" to { startActivity<AppBarUpActivity>() }
            ).forEach {
                val (text, click) = it
                button {
                    lparams(MATCH_PARENT); this.text = text; onClick { click() }
                }
            }
        }
    }
}
