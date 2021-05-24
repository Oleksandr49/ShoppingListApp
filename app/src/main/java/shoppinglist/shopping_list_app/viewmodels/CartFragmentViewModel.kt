package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.usecases.base.*
import java.util.*
import javax.inject.Inject

class CartFragmentViewModel @Inject constructor(private val readUseCase: ReadListWithConditionUseCase<CartItem>,
                                                private val createUseCase: CreateUseCase<Cart>,
                                                private val updateUseCase: UpdateUseCase<CartItem>): BaseViewModel() {

    var currentList = MutableLiveData<List<CartItem>>()

    fun updateList(){
        readUseCase.readListWithCondition(observer = BaseSingleObserver({currentList.postValue(it)},{compositeDisposable.add(it) }))
    }

    fun confirmCart(){
        createCart()
    }

    private fun createCart(){
        val cart = Cart(date = Date().toString())
        createUseCase.create(cart, BaseSingleObserver({cartId -> bindCurrentItemsToCart(cartId)},{disposable -> compositeDisposable.add(disposable)}))
    }

    private fun bindCurrentItemsToCart(cartId:Long){
        currentList.value?.let{itemList ->
            var counter = 0
            for (item in itemList) {
                counter++
                if(counter <= itemList.size){
                    item.cartId = cartId
                    updateUseCase.update(item, BaseCompletableObserver({},{disposable -> compositeDisposable.add(disposable)}))
                }
                else{
                    item.cartId = cartId
                    updateUseCase.update(item, BaseCompletableObserver({updateList()},{disposable -> compositeDisposable.add(disposable)}))
                }
            }
        }
    }
}