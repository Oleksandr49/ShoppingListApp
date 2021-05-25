package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.base.BaseViewCallBack
import shoppinglist.shopping_list_app.views.viewHolders.ProductViewHolder
import shoppinglist.shoppinglistapp.R

class ProductsAdapter: BaseAdapter<ProductViewHolder, BaseProduct, BaseViewCallBack>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(inflater.inflate(R.layout.product_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productName.text = itemsList[position].name
    }

    override fun updateList(updatedList: List<BaseProduct>) {
        val listUpdates = DiffUtil.calculateDiff(ProductDiffUtilCallback(itemsList, updatedList))
        itemsList = updatedList
        listUpdates.dispatchUpdatesTo(this)
    }
}

private class ProductDiffUtilCallback(oldList: List<BaseProduct>, newList: List<BaseProduct>):
        BaseDiffUtillCallback<BaseProduct>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].productID == newList[newItemPosition].productID

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].name == newList[newItemPosition].name

}