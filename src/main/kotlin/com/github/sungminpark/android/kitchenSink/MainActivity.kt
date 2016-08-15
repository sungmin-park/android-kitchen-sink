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
            button {
                lparams(width = MATCH_PARENT); text = "App Bar"
                onClick { startActivity<AppBarActivity>() }
            }
        }
    }
}
