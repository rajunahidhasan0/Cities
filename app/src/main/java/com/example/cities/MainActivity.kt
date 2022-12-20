package com.example.cities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cities.ProfileListAdapter
import com.example.cities.R
import com.example.cities.city
import com.google.android.material.internal.ContextUtils.getActivity
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(){
    lateinit var firstFragmentBtn: Button
    lateinit var secondFragmentBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, Fragment1()).commit()
        firstFragmentBtn=findViewById(R.id.fragment1btn)
        secondFragmentBtn=findViewById(R.id.fragment2btn)

        firstFragmentBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                //replaceFragment(Fragment1())
                firstFragmentBtn.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.blue))
                secondFragmentBtn.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.gray))
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, Fragment1()).commit()
            }
        })

        secondFragmentBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                //replaceFragment(Fragment2())
                firstFragmentBtn.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.gray))
                secondFragmentBtn.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.blue))
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, Fragment2()).commit()

            }
        })
    }
}