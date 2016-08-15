package com.github.sungminpark.android.kitchenSink

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

fun Context.attribute(value: Int): TypedValue {
    val ret = TypedValue()
    theme.resolveAttribute(value, ret, true)
    return ret
}

fun Context.attrAsDimen(value: Int): Int {
    return TypedValue.complexToDimensionPixelSize(attribute(value).data, resources.displayMetrics)
}

class AppBarActivity : AppCompatActivity() {
    var like = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            toolbar {
                lparams(MATCH_PARENT, attrAsDimen(R.attr.actionBarSize))
                backgroundColor = attribute(R.attr.colorPrimary).data
                setSupportActionBar(this)
            }
        }
    }

    /**
     * If you are calling  setSupportActionBar() you don't need to use toolbar.inflateMenu() because the Toolbar is
     * acting as your ActionBar. All menu related callbacks are via the default ones.
     * The only time you need to call toolbar.inflateMenu() is when you are using the Toolbar as a standalone widget.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_toggle_like -> {
                like = like == false
                item.setIcon(if (like) R.drawable.ic_favorite_black_24dp else R.drawable.ic_favorite_border_black_24dp)
                false
            }

            R.id.action_open_setting -> {
                toast("설정은 준비 중입니다.")
                false
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

