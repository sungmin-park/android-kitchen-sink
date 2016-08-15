package com.github.sungminpark.android.kitchenSink

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            listOf(AppBarActivity::class.java, AppBarUpActivity::class.java, AppBarActionViewsActivity::class.java)
                    .map { cls ->
                        cls.simpleName to View.OnClickListener { startActivity(Intent(this@MainActivity, cls)) }
                    }
                    .forEach {
                        val (text, click) = it
                        button {
                            lparams(MATCH_PARENT); this.text = text; setOnClickListener(click)
                        }
                    }
        }
    }
}
