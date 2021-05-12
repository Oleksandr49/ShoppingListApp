package shoppinglist.shopping_list_app.views.adapters

import shoppinglist.shopping_list_app.views.base.BaseViewCallBack

interface SLAdapterCallback: BaseViewCallBack {

    fun removePosition(position:Long)
    fun editPosition(position: Long)
}