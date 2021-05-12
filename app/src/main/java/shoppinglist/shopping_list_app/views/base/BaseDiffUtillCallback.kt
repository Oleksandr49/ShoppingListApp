package shoppinglist.shopping_list_app.views.base

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtillCallback<T>(val oldList: List<T>, val newList: List<T>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    abstract override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

    abstract override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
}