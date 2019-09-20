package com.tooflexdev.dokomaps.ui.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.TopSearch

class TopSearchAdapter(private var topSearches: List<TopSearch?> = emptyList()) : RecyclerView.Adapter<TopSearchAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_top_search, parent, false))
    }

    override fun getItemCount(): Int {
        return topSearches.size
    }

    fun setTopSearches(topSearches: List<TopSearch>?) {
        if (topSearches != null) {
            this.topSearches = topSearches
        }
    }

    fun getTopSearches(): List<TopSearch?> {
        return topSearches
    }

    fun getTopSearch(position: Int) : TopSearch? {
        return topSearches[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val topSearch = topSearches[position]
        holder.name.text = "${topSearch?.name}"

    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val name: TextView = view.findViewById(R.id.tvItemTopSearches)

    }

}