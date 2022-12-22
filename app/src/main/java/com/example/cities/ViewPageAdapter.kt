package com.example.cities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->Fragment1()
            1->Fragment2()
            else->Fragment3()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position)
        {
            0->"Bangladesh"
            1->"India"
            else->"Pakistan"
        }
    }
}