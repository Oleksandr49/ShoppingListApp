package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val readAllUseCase:ReadUseCase<Cart>): BaseViewModel() {

    val allCarts = MutableLiveData<List<Cart>>()

    fun loadCarts(){
        readAllUseCase.readAll(BaseSingleObserver({list -> allCarts.postValue(list)},{disposable -> compositeDisposable.add(disposable)}))
    }
}