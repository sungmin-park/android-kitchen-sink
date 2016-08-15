package com.github.sungminpark.android.kitchenSink

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.support.v7.widget.ShareActionProvider
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import org.jetbrains.anko.appcompat.v7.onQueryTextListener
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.dip
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class AppBarActionViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            toolbar {
                lparams(ViewGroup.LayoutParams.MATCH_PARENT, attrAsDimen(R.attr.actionBarSize))
                backgroundColor = attribute(R.attr.colorPrimary).data
                setElevation(dip(4))
                setSupportActionBar(this)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.appbar_action_views_menu, menu)
        val item = menu.findItem(R.id.action_search)
        MenuItemCompat.setOnActionExpandListener(item, object : MenuItemCompat.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                toast("expand searchView")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                toast("collapse searchView")
                return true
            }
        })
        val searchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.onQueryTextListener {
            onQueryTextSubmit {
                if (it != null) {
                    toast(it)
                }
                false
            }
        }

        val shareItem = menu.findItem(R.id.action_share)
        val shareActionProvider = MenuItemCompat.getActionProvider(shareItem) as ShareActionProvider
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "제목")
        intent.putExtra(Intent.EXTRA_TEXT, "내용")
        shareActionProvider.setShareIntent(intent)
        return super.onCreateOptionsMenu(menu)
    }
}
