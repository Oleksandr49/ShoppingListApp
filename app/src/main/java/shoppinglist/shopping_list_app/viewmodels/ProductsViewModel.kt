package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class ProductsViewModel @Inject constructor(private val readUseCAse: ReadUseCase<BaseProduct>): BaseViewModel() {

    var currentList = MutableLiveData<List<BaseProduct>>()

    fun updateList(){
        readUseCAse.readAll(observer = BaseSingleObserver({ param -> currentList.postValue(param)},
                {disposable -> compositeDisposable.add(disposable) })
        )
    }

}