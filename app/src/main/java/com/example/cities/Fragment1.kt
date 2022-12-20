package com.example.cities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cities.R

class Fragment1 : Fragment(), ProfileListAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView

    val cityl = ArrayList<city>()
    private lateinit var adapter:ProfileListAdapter
    //(city("Nahid", R.drawable.ic_launcher_background), city("Raju", R.drawable.ic_launcher_foreground))
    val citynam= arrayListOf<String>("Dhaka","Rajshahi","Sylhet","Barishal","Khulna","Rangpur","Dinajpur","Bandarban","Comilla","Bogra")
    val cityimg=arrayListOf<Int>(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10)

    val descStr ="Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
            " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in" +
            " reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
            "mollit anim id est laborum."

    //lateinit var view?: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_1, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        adapter = ProfileListAdapter(cityl, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        // Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem:city = cityl[position]
        adapter.notifyItemChanged(position)
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    fun loadData(){
        for (i in 0..1000){
            cityl.add(city(citynam[i%10],cityimg[i%10],descStr,false))
        }

        adapter.setDataList((cityl))
        adapter.notifyDataSetChanged()
    }
}