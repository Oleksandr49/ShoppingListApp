package shoppinglist.shopping_list_app.views.adapters

import android.view.View
import android.view.ViewGroup
import shoppinglist.shopping_list_app.model.dataModels.Product
import shoppinglist.shopping_list_app.views.base.BaseAdapter
import shoppinglist.shopping_list_app.views.viewHolders.ProductViewHolder

class ProductsAdapter: BaseAdapter<ProductViewHolder, Product, ProductAdapterCallback>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

    }

    override fun updateList(updatedList: List<Product>) {

    }
}