package shoppinglist.shopping_list_app.viewmodels


import shoppinglist.shopping_list_app.model.dataModels.SLPosition
import shoppinglist.shopping_list_app.model.repository.SLPositionRepository
import shoppinglist.shopping_list_app.model.usecases.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.CreationUseCase
import javax.inject.Inject

class SLPositionCreationViewModel @Inject constructor(private val useCase: CreationUseCase<SLPositionRepository, SLPosition>): BaseViewModel(){

    fun create(name:String, amount:Double){
        SLPosition(productName = name, productAmount = amount).also {
            useCase.execute(it, BaseCompletableObserver({},{disposable -> compositeDisposable.add(disposable)}))
        }
    }
}