package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.SLPosition
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.SLPositionViewHolder
import shoppinglist.shoppinglistapp.R

class SLAdapter : BaseAdapter<SLPositionViewHolder, SLPosition, SLAdapterCallback>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SLPositionViewHolder {
        LayoutInflater.from(parent.context).also {
            return SLPositionViewHolder(it.inflate(R.layout.s_l_position, parent, false)) }
    }

    override fun onBindViewHolder(holder: SLPositionViewHolder, position: Int) {
        holder.productName.text = itemsList[position].productName
        holder.productName.setOnClickListener { itemsList[holder.adapterPosition].ID?.let { position ->
            viewCallback?.editPosition(position) } }
        holder.productAmount.text = itemsList[position].productAmount.toString()
        holder.inCart.setOnClickListener { itemsList[holder.adapterPosition].ID?.let { position -> viewCallback?.removePosition(position)
            }
        }
    }

    override fun updateList(updatedList: List<SLPosition>) {
        DiffUtil.calculateDiff(SLDiffUtillCallback(itemsList, updatedList)).also {itemsList = updatedList
            it.dispatchUpdatesTo(this)}
    }
}

private class SLDiffUtillCallback(oldList: List<SLPosition>, newList: List<SLPosition>):
    BaseDiffUtillCallback<SLPosition>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].ID == newList[newItemPosition].ID

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].productName == newList[newItemPosition].productName

}