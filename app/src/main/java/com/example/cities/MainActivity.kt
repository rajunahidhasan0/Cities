package com.example.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.viewpager.widget.ViewPager
import com.example.cities.R
import com.example.cities.R.id.basicinfo
import com.example.cities.ViewPageAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit private var tab: TabLayout
    lateinit private var viewPager: ViewPager
    private lateinit var fab: View
    //private lateinit var basicinfo: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab = findViewById(R.id.tab)
        viewPager = findViewById(R.id.viewPager)

        var adapter:ViewPageAdapter = ViewPageAdapter(getSupportFragmentManager())
        viewPager.setAdapter(adapter)
        tab.setupWithViewPager(viewPager)

        fab = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()

            var alert:AlertDialog.Builder = AlertDialog.Builder(this)
            var mView:View = layoutInflater.inflate(R.layout.custom_dialog, null)
            alert.setView(mView)
            var alertdialog:AlertDialog = alert.create()
            alertdialog.setCanceledOnTouchOutside(false)
            alertdialog.show()
        }
    }
}
