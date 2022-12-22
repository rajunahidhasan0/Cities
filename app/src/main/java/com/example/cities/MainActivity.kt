package com.example.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.cities.R
import com.example.cities.ViewPageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit private var tab: TabLayout
    lateinit private var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab = findViewById(R.id.tab)
        viewPager = findViewById(R.id.viewPager)

        var adapter:ViewPageAdapter = ViewPageAdapter(getSupportFragmentManager())
        viewPager.setAdapter(adapter)
        tab.setupWithViewPager(viewPager)
    }
}