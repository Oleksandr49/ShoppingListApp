package shoppinglist.shopping_list_app.views.adapters

import shoppinglist.shopping_list_app.views.base.BaseViewCallBack

interface SLAdapterCallback: BaseViewCallBack {

    fun movePositionToCart(position:Long)
    fun editPosition(position: Long)
    fun removePosition(position: Long)
}