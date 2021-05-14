package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.CartItemDao
import shoppinglist.shopping_list_app.model.repository.CartItemsRep
import shoppinglist.shopping_list_app.model.repository.ListItemDao
import shoppinglist.shopping_list_app.model.repository.ListItemRep
import shoppinglist.shopping_list_app.model.usecases.*
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import javax.inject.Inject

class SLViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase<ListItem, ListItemDao, ListItemRep>,
                                      private val getOneUseCase: GetOneUseCase<ListItem, ListItemDao, ListItemRep>,
                                      private val creationUseCase: CreationUseCase<CartItem, CartItemDao, CartItemsRep>,
                                      private val deletionUseCase: DeletionUseCase<ListItem, ListItemDao, ListItemRep>): BaseViewModel() {

    var currentList = MutableLiveData<List<ListItem>>()

    fun updateList(){
        getAllUseCase.getAll(observer = BaseSingleObserver({ param -> currentList.postValue(param)},
            {disposable -> compositeDisposable.add(disposable) })
        )
    }

    fun movePositionToCart(id:Long){
        getPosition(id)
    }

    private fun getPosition(id:Long) {
        getOneUseCase.getOne(id,
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
        deletionUseCase.delete(id, BaseCompletableObserver({updateList()},{ disposable -> compositeDisposable.add(disposable)}))
    }
}