package shoppinglist.shopping_list_app.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.base.BaseDiffUtillCallback
import shoppinglist.shopping_list_app.views.viewHolders.ProductViewHolder
import shoppinglist.shoppinglistapp.R

class ProductsAdapter: BaseAdapter<ProductViewHolder, BaseProduct, ProductAdapterCallback>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        LayoutInflater.from(parent.context).also {
            return ProductViewHolder(it.inflate(R.layout.product_view_holder, parent, false)) }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productName.text = itemsList[position].name
    }

    override fun updateList(updatedList: List<BaseProduct>) {
        DiffUtil.calculateDiff(ProductDiffUtillCallback(itemsList, updatedList)).also {itemsList = updatedList
            it.dispatchUpdatesTo(this)}
    }
}

private class ProductDiffUtillCallback(oldList: List<BaseProduct>, newList: List<BaseProduct>):
        BaseDiffUtillCallback<BaseProduct>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].productID == newList[newItemPosition].productID

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            (areItemsTheSame(oldItemPosition, newItemPosition) && areNamesTheSame(oldItemPosition, newItemPosition))

    private fun areNamesTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].name == newList[newItemPosition].name

}