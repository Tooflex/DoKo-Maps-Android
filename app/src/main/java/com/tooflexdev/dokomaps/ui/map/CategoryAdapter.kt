package com.tooflexdev.dokomaps.ui.map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tooflexdev.dokomaps.R
import com.tooflexdev.dokomaps.model.Category
import java.security.SecureRandom



class CategoryAdapter(private var categories: List<Category?> = emptyList()) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>()  {


    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            inflater.inflate(
                R.layout.item_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setCategories(categories: List<Category>?) {
        if (categories != null) {
            this.categories = categories
        }
    }

    fun getCategories(): List<Category?> {
        return categories
    }

    fun getCategory(position: Int) : Category? {
        return categories[position]
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val category = categories[position]
        holder.name.text = "${category?.title}"
        holder.name.setOnClickListener {
            // val intentCategoryDetails = Intent(context, CategoryDetails::class.java)
            // intentCategoryDetails.putExtra("category",category?.title)
            // context?.startActivity(intentCategoryDetails)
        }


        getRandomColor()?.let { holder.card.setCardBackgroundColor(it) }

    }

    private fun getRandomColor(): Int? {
        val rgen = SecureRandom()
        val androidColors = this.context?.resources?.getIntArray(R.array.category_colors)

        return androidColors?.get(rgen.nextInt(androidColors.size))
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        val card: CardView = view.findViewById(R.id.cvItemCategory)
        val name: TextView = view.findViewById(R.id.tvItemCategory)

    }

}

