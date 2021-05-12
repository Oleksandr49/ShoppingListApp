package shoppinglist.shopping_list_app.views.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shoppinglistapp.R

class CartPositionViewHolder(item: View): RecyclerView.ViewHolder(item) {

    var productName: TextView = itemView.findViewById(R.id.Cart_position_name)
    var productAmount: TextView = itemView.findViewById(R.id.Cart_position_amount)
}