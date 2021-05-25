package shoppinglist.shopping_list_app.views.adapters

import shoppinglist.shopping_list_app.views.base.BaseViewCallBack

interface HistoryAdapterCallback: BaseViewCallBack {

    fun goToDetails(cartID:Long)
}