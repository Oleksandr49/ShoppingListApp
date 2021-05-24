package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.SLPositionViewHolder
import shoppinglist.shoppinglistapp.R

class SLAdapter : BaseAdapter<SLPositionViewHolder, ListItem, SLAdapterCallback>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SLPositionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SLPositionViewHolder(inflater.inflate(R.layout.s_l_position, parent, false))
    }

    override fun onBindViewHolder(holder: SLPositionViewHolder, position: Int) {
        val holderItem = itemsList[position]
        holder.productName.text = holderItem.name
        holder.productAmount.text = holderItem.amount.toString()
        holderItem.id?.let{ positionId ->
            holder.productName.setOnClickListener { viewCallback?.editPosition(positionId)}
            holder.inCart.setOnClickListener { viewCallback?.movePositionToCart(positionId)}
        }
    }

    override fun updateList(updatedList: List<ListItem>) {
        val listUpdates = DiffUtil.calculateDiff(SLDiffUtilCallback(itemsList, updatedList))
        itemsList = updatedList
        listUpdates.dispatchUpdatesTo(this)
    }
}

private class SLDiffUtilCallback(oldList: List<ListItem>, newList: List<ListItem>):
    BaseDiffUtillCallback<ListItem>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == newList[newItemPosition].name

}