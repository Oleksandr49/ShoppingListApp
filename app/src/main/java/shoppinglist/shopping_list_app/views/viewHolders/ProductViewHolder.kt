package shoppinglist.shopping_list_app.views.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shoppinglistapp.R

class ProductViewHolder(item: View): RecyclerView.ViewHolder(item) {

    var productName: TextView = item.findViewById(R.id.Product_name)
}