package shoppinglist.shopping_list_app.viewmodels


import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.ListItemDao
import shoppinglist.shopping_list_app.model.repository.ProductsRep
import shoppinglist.shopping_list_app.model.repository.ListItemRep
import shoppinglist.shopping_list_app.model.repository.ProductDao
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.CreationUseCase
import shoppinglist.shopping_list_app.model.usecases.GetAllUseCase
import javax.inject.Inject

class SLPositionCreationViewModel @Inject constructor(private val creationUseCase: CreationUseCase<ListItem, ListItemDao, ListItemRep >,
                                                      private val baseProductUseCase: CreationUseCase<BaseProduct, ProductDao, ProductsRep>,
                                                      private val allProducts: GetAllUseCase<BaseProduct, ProductDao, ProductsRep> ): BaseViewModel(){

    val currentList = MutableLiveData<List<BaseProduct>>()

    fun create(name:String, amount:Double){
        ListItem(name = name, amount = amount, productId = 1L).also {
            creationUseCase.create(it, BaseCompletableObserver({},{ disposable -> compositeDisposable.add(disposable)}))
        }
        BaseProduct(name = name).also {
            baseProductUseCase.create(it, BaseCompletableObserver({}, { disposable -> compositeDisposable.add(disposable)}))
        }
    }

    fun loadProducts(){
        allProducts.getAll(observer = BaseSingleObserver({ list -> currentList.postValue(list)}, { disposable -> compositeDisposable.add(disposable)}))
    }
}