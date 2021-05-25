package shoppinglist.shopping_list_app.views.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shoppinglistapp.R

class HistoryPositionViewHolder(item: View): RecyclerView.ViewHolder(item)  {

    var cartDate: TextView = item.findViewById(R.id.Cart_date)
}