package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class CartFragmentViewModel @Inject constructor(private val readUseCase: ReadUseCase<CartItem>,
                                                private val deleteUseCase: DeleteUseCase<CartItem>): BaseViewModel() {

    var currentList = MutableLiveData<List<CartItem>>()

    fun updateList(){
        readUseCase.readAll(observer = BaseSingleObserver({
            currentList.postValue(it) },{compositeDisposable.add(it) }))
    }

    fun confirmCart(){
        deleteUseCase.deleteAll(observer = BaseCompletableObserver({updateList()},{compositeDisposable.add(it)}))
    }
}