package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter_rcy_mainService(private val mList: List<CategoriesRespon>): RecyclerView.Adapter<Adapter_rcy_mainService.viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcyitem_mainservices, parent, false)

        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView.text=ItemsViewModel.All_Places_Types[position].place_type_name
        holder.itemView.setOnClickListener {

            val context=holder.textView.context

            var intent= Intent(context, Categories_CHB::class.java)
            intent.putExtra("typeId",ItemsViewModel.All_Places_Types[position].place_type_id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }


    class viewholder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_station)
        val textView: TextView = itemView.findViewById(R.id.txt_station)



    }
}