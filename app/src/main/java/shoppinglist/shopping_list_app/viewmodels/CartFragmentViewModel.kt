package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartPosition
import shoppinglist.shopping_list_app.model.repository.CartPositionsRepository
import shoppinglist.shopping_list_app.model.usecases.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.DeleteAllUseCase
import shoppinglist.shopping_list_app.model.usecases.GetAllUseCase
import javax.inject.Inject

class CartFragmentViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase<CartPositionsRepository, CartPosition>,
                                                private val deleteAllUseCase: DeleteAllUseCase<CartPositionsRepository, CartPosition>): BaseViewModel() {

    var currentList = MutableLiveData<List<CartPosition>>()

    fun updateList(){
        getAllUseCase.execute(observer = BaseSingleObserver({
            currentList.postValue(it) },{compositeDisposable.add(it) }))
    }

    fun confirmCart(){
        deleteAllUseCase.execute(observer = BaseCompletableObserver({updateList()},{compositeDisposable.add(it)}))
    }
}