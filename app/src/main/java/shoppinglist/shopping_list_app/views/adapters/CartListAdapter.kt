package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.CartPositionViewHolder
import shoppinglist.shoppinglistapp.R

class CartListAdapter: BaseAdapter<CartPositionViewHolder, CartItem, SLAdapterCallback>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartPositionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CartPositionViewHolder(inflater.inflate(R.layout.s_l_position, parent, false))
    }

    override fun onBindViewHolder(holder: CartPositionViewHolder, position: Int) {
        holder.productName.text = itemsList[position].name
        holder.productAmount.text = itemsList[position].amount.toString()
    }

    override fun updateList(updatedList: List<CartItem>) {
        val listUpdates = DiffUtil.calculateDiff(CartDiffUtilCallback(itemsList, updatedList))
        itemsList = updatedList
        listUpdates.dispatchUpdatesTo(this)
    }
}

private class CartDiffUtilCallback(oldList: List<CartItem>, newList: List<CartItem>):
    BaseDiffUtillCallback<CartItem>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == newList[newItemPosition].name

}