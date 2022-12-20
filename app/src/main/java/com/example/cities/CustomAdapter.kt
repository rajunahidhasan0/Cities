package com.example.cities
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileListAdapter(var list: ArrayList<city>,
    private val listener: OnItemClickListener): RecyclerView.Adapter<ProfileListAdapter.ProfileItemViewHolder>() {

    companion object{
        private val TAG:String = "test-${ProfileListAdapter.javaClass}"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lv_item, parent, false)
        val viewHolder = ProfileItemViewHolder(view)
        return viewHolder
    }

    fun setDataList(arrayList: ArrayList<city>){
        list = arrayList
    }

    override fun onBindViewHolder(holder: ProfileItemViewHolder, position: Int) {
        holder.textView.text = list[position].name
        holder.textView2.text = list[position].desc
        holder.imageView.setImageResource(list[position].image)
        holder.btn.tag = position
        if(list[position].isExpanded){
            holder.textView2.visibility = View.VISIBLE
            holder.btnView.visibility = View.INVISIBLE
        }else{
            holder.textView2.visibility = View.INVISIBLE
            holder.btnView.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ProfileItemViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        var textView: TextView
        var textView2: TextView
        var imageView: ImageView
        val btnView: LinearLayout
        val btn: Button

        init {
            textView = view.findViewById(R.id.name)
            textView2 = view.findViewById(R.id.desc)
            imageView = view.findViewById(R.id.imgView)
            btnView = view.findViewById<LinearLayout>(R.id.buttonView)
            btn =  view.findViewById(R.id.button)

            btn.setOnClickListener{
                val position:Int = it.tag.toString().toInt()
                Log.i(TAG,"setOnClickListener called. item $position")

                if(position != RecyclerView.NO_POSITION){
                    textView2.visibility = View.VISIBLE
                    btnView.visibility = View.INVISIBLE
                    list[position].isExpanded = true
                    notifyDataSetChanged()
                    //listener.onItemClick(position)
                }
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }
}
