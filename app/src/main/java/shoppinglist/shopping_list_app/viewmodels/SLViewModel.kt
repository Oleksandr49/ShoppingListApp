package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.CartPosition
import shoppinglist.shopping_list_app.model.dataModels.SLPosition
import shoppinglist.shopping_list_app.model.repository.CartPositionsRepository
import shoppinglist.shopping_list_app.model.repository.SLPositionRepository
import shoppinglist.shopping_list_app.model.usecases.*
import javax.inject.Inject

class SLViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase<SLPositionRepository, SLPosition>,
                                      private val getOneUseCase: GetOneUseCase<SLPositionRepository, SLPosition>,
                                      private val creationUseCase: CreationUseCase<CartPositionsRepository, CartPosition>,
                                      private val deletionUseCase: DeletionUseCase<SLPositionRepository, SLPosition>): BaseViewModel() {

    var currentList = MutableLiveData<List<SLPosition>>()

    fun updateList(){
        getAllUseCase.execute(observer = BaseSingleObserver({param -> currentList.postValue(param)},
            {disposable -> compositeDisposable.add(disposable) }))
    }

    fun movePositionToCart(id:Long){
        getPosition(id)
    }

    private fun getPosition(id:Long) {
        getOneUseCase.execute(id,
            BaseSingleObserver({ param -> createCartPosition(param) },
                { disposable -> compositeDisposable.add(disposable) })
        )
    }

    private fun createCartPosition(position: SLPosition){
        CartPosition(productName = "carted", productAmount = position.productAmount).also { cartPosition ->
            position.positionID?.let { ID ->
                creationUseCase.execute(cartPosition, BaseCompletableObserver({deleteSLPosition(ID)},
                    {disposable -> compositeDisposable.add(disposable)}))}

        }
    }

    fun deleteSLPosition(id:Long){
        deletionUseCase.execute(id, BaseCompletableObserver({updateList()},{disposable -> compositeDisposable.add(disposable)}))
    }
}