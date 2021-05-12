package shoppinglist.shopping_list_app.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.CartPosition
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.CartPositionViewHolder
import shoppinglist.shoppinglistapp.R

class CartListAdapter: BaseAdapter<CartPositionViewHolder, CartPosition, SLAdapterCallback>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartPositionViewHolder {
        LayoutInflater.from(parent.context).also {
            return CartPositionViewHolder(it.inflate(R.layout.cart_position_view_holder, parent, false)) }
    }

    override fun onBindViewHolder(holder: CartPositionViewHolder, position: Int) {
        holder.productName.text = itemsList[position].productName
        holder.productAmount.text = itemsList[position].productAmount.toString()
    }

    override fun updateList(updatedList: List<CartPosition>) {
        DiffUtil.calculateDiff(CartDiffUtillCallback(itemsList, updatedList)).also {itemsList = updatedList
            it.dispatchUpdatesTo(this)}
    }
}

private class CartDiffUtillCallback(oldList: List<CartPosition>, newList: List<CartPosition>):
    BaseDiffUtillCallback<CartPosition>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].ID == newList[newItemPosition].ID

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].productName == newList[newItemPosition].productName

}