package com.tooflexdev.dokomaps.ui.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.TopCountry

class TopCountryAdapter(private var topCountries: List<TopCountry?> = emptyList()) : RecyclerView.Adapter<TopCountryAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_top_countries, parent, false))
    }

    override fun getItemCount(): Int {
        return topCountries.size
    }

    fun setCountries(topCountries: List<TopCountry>?) {
        if (topCountries != null) {
            this.topCountries = topCountries
        }
    }

    fun getCountries(): List<TopCountry?> {
        return topCountries
    }

    fun getCountry(position: Int) : TopCountry? {
        return topCountries[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val topCountry = topCountries[position]
        holder.name.text = "${topCountry?.name}"

    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val name: TextView = view.findViewById(R.id.tvItemTopCountries)

    }

}

