package shoppinglist.shopping_list_app.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class SLPositionCreationViewModel @Inject constructor(private val createListItemUseCase: CreateUseCase<ListItem>,
                                                      private val createBaseProductUseCase: CreateUseCase<BaseProduct>,
                                                      private val readUseCase: ReadUseCase<BaseProduct> ): BaseViewModel(){

    val currentList = MutableLiveData<List<BaseProduct>>()
    val createdProduct = MutableLiveData<Long>()

    fun create(name:String, amount:Double){
        ListItem(name = name, amount = amount, productId = 1L).also {
            createListItemUseCase.create(it, BaseSingleObserver({ id -> Log.i("ADDED", "ID:$id")},{ disposable -> compositeDisposable.add(disposable)}))
        }
        BaseProduct(name = name).also {
            createBaseProductUseCase.create(it, BaseSingleObserver({ id -> Log.i("ADDED", "ID:$id")},{ disposable -> compositeDisposable.add(disposable)}))
        }
    }

    fun loadProducts(){
        readUseCase.readAll(observer = BaseSingleObserver({ list -> currentList.postValue(list)}, { disposable -> compositeDisposable.add(disposable)}))
    }
}