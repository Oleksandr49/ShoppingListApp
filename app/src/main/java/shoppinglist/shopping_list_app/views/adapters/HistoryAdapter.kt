package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.HistoryPositionViewHolder
import shoppinglist.shoppinglistapp.R

class HistoryAdapter: BaseAdapter<HistoryPositionViewHolder, Cart, HistoryAdapterCallback>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryPositionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HistoryPositionViewHolder(inflater.inflate(R.layout.history_viewholder, parent, false))
    }

    override fun onBindViewHolder(holder: HistoryPositionViewHolder, position: Int) {
        val cart = itemsList[position]
        holder.cartDate.text = cart.date
        cart.cartId?.let {id -> holder.cartDate.setOnClickListener { viewCallback?.goToDetails(id)}}
    }

    override fun updateList(updatedList: List<Cart>) {
        val listUpdates = DiffUtil.calculateDiff(HistoryDiffUtilCallback(itemsList, updatedList))
        itemsList = updatedList
        listUpdates.dispatchUpdatesTo(this)
    }


}

private class HistoryDiffUtilCallback(oldList: List<Cart>, newList: List<Cart>):
    BaseDiffUtillCallback<Cart>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].cartId == newList[newItemPosition].cartId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areDatesTheSame(oldItemPosition, newItemPosition))

    private fun areDatesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].date == newList[newItemPosition].date

}