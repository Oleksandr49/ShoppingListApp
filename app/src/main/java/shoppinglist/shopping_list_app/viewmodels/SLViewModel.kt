package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.usecases.base.*
import javax.inject.Inject

class SLViewModel @Inject constructor(private val readUseCase: ReadUseCase<ListItem>,
                                      private val createUseCase: CreateUseCase<CartItem>,
                                      private val deleteUseCase: DeleteUseCase<ListItem>): BaseViewModel() {

    var currentList = MutableLiveData<List<ListItem>>()

    fun updateList(){
        readUseCase.readAll(observer = BaseSingleObserver({ param -> currentList.postValue(param)},
            {disposable -> compositeDisposable.add(disposable) })
        )
    }

    fun movePositionToCart(id:Long){
        getPosition(id)
    }

    private fun getPosition(id:Long) {
        readUseCase.read(id,
            BaseSingleObserver({ param -> createCartPosition(param) },
                { disposable -> compositeDisposable.add(disposable) })
        )
    }

    private fun createCartPosition(position: ListItem){
        /*
        CartItem(name = "carted", amount = position.amount).also { cartPosition ->
            position.positionID?.let { ID ->
                creationUseCase.execute(cartPosition, BaseCompletableObserver({deleteSLPosition(ID)},
                    {disposable -> compositeDisposable.add(disposable)}))}

        }
         */
    }

    fun deleteSLPosition(id:Long){
        deleteUseCase.delete(id, BaseCompletableObserver({updateList()},{ disposable -> compositeDisposable.add(disposable)}))
    }
}