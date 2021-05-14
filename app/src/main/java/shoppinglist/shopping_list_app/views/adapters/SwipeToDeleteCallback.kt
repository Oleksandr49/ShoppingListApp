package shoppinglist.shopping_list_app.views.adapters

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shopping_list_app.views.adapters.SLAdapter

class SwipeToDeleteCallback(val adapter:SLAdapter): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) = true

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //adapter.itemsList[viewHolder.adapterPosition].id.let {adapter.viewCallback?.removePosition(it) }
    }
}