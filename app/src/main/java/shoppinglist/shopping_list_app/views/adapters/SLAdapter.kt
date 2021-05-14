package shoppinglist.shopping_list_app.views.adapters

import android.annotation.SuppressLint
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
        LayoutInflater.from(parent.context).also {
            return SLPositionViewHolder(it.inflate(R.layout.s_l_position, parent, false)) }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: SLPositionViewHolder, position: Int) {
        holder.productName.text = itemsList[position].name
       // holder.productName.setOnClickListener { itemsList[holder.adapterPosition].id.let { position ->
         //   viewCallback?.editPosition(position) } }
        holder.productAmount.text = itemsList[position].amount.toString()
        //holder.inCart.setOnClickListener { itemsList[holder.adapterPosition].id.let { position -> viewCallback?.movePositionToCart(position)
          //  }
        //}
    }

    override fun updateList(updatedList: List<ListItem>) {
        DiffUtil.calculateDiff(SLDiffUtillCallback(itemsList, updatedList)).also {itemsList = updatedList
            it.dispatchUpdatesTo(this)}
    }
}

private class SLDiffUtillCallback(oldList: List<ListItem>, newList: List<ListItem>):
    BaseDiffUtillCallback<ListItem>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == newList[newItemPosition].name

}