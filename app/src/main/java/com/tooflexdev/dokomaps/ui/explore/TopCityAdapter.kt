package com.tooflexdev.dokomaps.ui.explore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tooflexdev.dokomaps.CityDetails
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.TopCity



class TopCityAdapter(private var topCities: List<TopCity?> = emptyList()) : RecyclerView.Adapter<TopCityAdapter.ViewHolder>()  {


    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_top_cities, parent, false))
    }

    override fun getItemCount(): Int {
        return topCities.size
    }

    fun setCities(topCities: List<TopCity>?) {
        if (topCities != null) {
            this.topCities = topCities
        }
    }

    fun getCities(): List<TopCity?> {
        return topCities
    }

    fun getCity(position: Int) : TopCity? {
        return topCities[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val TopCity = topCities[position]
        holder.name.text = "${TopCity?.name}"
        context?.let { Glide.with(it).load(TopCity?.url).into(holder.img) }
        holder.name.setOnClickListener {
            val intentCityDetails = Intent(context, CityDetails::class.java)
            intentCityDetails.putExtra("city",TopCity?.name)
            context?.startActivity(intentCityDetails)
        }

    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val name: TextView = view.findViewById(R.id.tvItemTopCities)
        val img: ImageView = view.findViewById(R.id.ivTopCityCard)

    }

}

