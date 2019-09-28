package com.tooflexdev.dokomaps.ui.citydetails

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tooflexdev.dokomaps.MainActivity
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.DokoMap
import com.tooflexdev.dokomaps.ui.map.MapFragment

class DokoMapAdapter(private var dokoMaps: List<DokoMap?> = emptyList()) : RecyclerView.Adapter<DokoMapAdapter.ViewHolder>()  {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_map, parent, false))
    }

    override fun getItemCount(): Int {
        return dokoMaps.size
    }

    fun setDokoMaps(topDokoMaps: List<DokoMap>?) {
        if (topDokoMaps != null) {
            this.dokoMaps = topDokoMaps
        }
    }

    fun getDokoMaps(): List<DokoMap?> {
        return dokoMaps
    }

    fun getTag(position: Int) : DokoMap? {
        return dokoMaps[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dokoMap = dokoMaps[position]
        holder.title.text = "${dokoMap?.title}"
        holder.description.text = "${dokoMap?.description}"
        context?.let { Glide.with(it).load(dokoMap?.image).into(holder.image) }
        holder.itemView.setOnClickListener {
            val intentToMap = Intent(context, MainActivity::class.java)
            intentToMap.putExtra("open","map")
            context?.startActivity(intentToMap)
        }

    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val title: TextView = view.findViewById(R.id.tvItemDokoMapTitle)
        val description: TextView = view.findViewById(R.id.tvItemDokoMapDesc)
        val image: ImageView = view.findViewById(R.id.ivItemDokoMap)

    }

}