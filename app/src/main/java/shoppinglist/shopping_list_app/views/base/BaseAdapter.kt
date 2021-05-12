package shoppinglist.shopping_list_app.views.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T: RecyclerView.ViewHolder, P, C: BaseViewCallBack> : RecyclerView.Adapter<T>() {

    var itemsList : List<P> = ArrayList()
    var viewCallback: C? = null


    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T

    abstract override fun onBindViewHolder(holder: T, position: Int)

    override fun getItemCount() = itemsList.size

    abstract fun updateList(updatedList: List<P>)
}