package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.CartDao
import shoppinglist.shopping_list_app.model.repository.CartItemDao
import shoppinglist.shopping_list_app.model.repository.CartItemsRep
import shoppinglist.shopping_list_app.model.repository.CartRep
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.DeleteAllUseCase
import shoppinglist.shopping_list_app.model.usecases.GetAllUseCase
import shoppinglist.shopping_list_app.model.usecases.base.BaseUseCase
import javax.inject.Inject

class CartFragmentViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase<CartItem, CartItemDao, CartItemsRep>,
                                                private val deleteAllUseCase: DeleteAllUseCase<CartItem, CartItemDao, CartItemsRep>): BaseViewModel() {

    var currentList = MutableLiveData<List<CartItem>>()

    fun updateList(){
        getAllUseCase.getAll(observer = BaseSingleObserver({
            currentList.postValue(it) },{compositeDisposable.add(it) }))
    }

    fun confirmCart(){
        deleteAllUseCase.deleteAll(observer = BaseCompletableObserver({updateList()},{compositeDisposable.add(it)}))
    }
}