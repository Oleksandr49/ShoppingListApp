package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.repository.ProductDao
import shoppinglist.shopping_list_app.model.repository.ProductsRep
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.GetAllUseCase
import javax.inject.Inject

class ProductsViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase<BaseProduct, ProductDao, ProductsRep>): BaseViewModel() {

    var currentList = MutableLiveData<List<BaseProduct>>()

    fun updateList(){
        getAllUseCase.getAll(observer = BaseSingleObserver({ param -> currentList.postValue(param)},
                {disposable -> compositeDisposable.add(disposable) })
        )
    }

}