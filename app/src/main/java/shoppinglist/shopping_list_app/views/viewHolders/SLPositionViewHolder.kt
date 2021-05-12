package shoppinglist.shopping_list_app.views.viewHolders

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shoppinglistapp.R

class SLPositionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var productName: TextView = itemView.findViewById(R.id.Position_name)
    var productAmount: TextView = itemView.findViewById(R.id.Amount)
    var inCart: CheckBox = itemView.findViewById(R.id.inCart_checkBox)
}