package com.github.sungminpark.android.kitchenSink

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.dip
import org.jetbrains.anko.verticalLayout

class AppBarUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            toolbar(R.style.AppBarTheme) {
                lparams(ViewGroup.LayoutParams.MATCH_PARENT, attrAsDimen(R.attr.actionBarSize))
                backgroundColor = attribute(R.attr.colorPrimary).data
                setElevation(dip(4))
                setSupportActionBar(this)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }
}

