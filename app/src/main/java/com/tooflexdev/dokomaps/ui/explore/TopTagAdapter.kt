package com.tooflexdev.dokomaps.ui.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.TopTag

class TopTagAdapter(private var topTags: List<TopTag?> = emptyList()) : RecyclerView.Adapter<TopTagAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_top_tag, parent, false))
    }

    override fun getItemCount(): Int {
        return topTags.size
    }

    fun setTags(topTags: List<TopTag>?) {
        if (topTags != null) {
            this.topTags = topTags
        }
    }

    fun getTags(): List<TopTag?> {
        return topTags
    }

    fun getTag(position: Int) : TopTag? {
        return topTags[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val topTag = topTags[position]
        holder.name.text = "${topTag?.name}"

    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val name: TextView = view.findViewById(R.id.tvItemTopTags)

    }

}