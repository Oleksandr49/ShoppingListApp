package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.dataModels.relations.CartToCartItems
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class CartDetailsViewModel @Inject constructor(private val readUseCase: ReadUseCase<CartToCartItems>): BaseViewModel() {

    val cartItems = MutableLiveData<List<CartItem>>()

    fun loadCart(cartID:Long){
        readUseCase.read(cartID, BaseSingleObserver({cart -> cartItems.postValue(cart.cartItems)},{disposable -> compositeDisposable.add(disposable)}))
    }
}