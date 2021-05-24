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
                                                      private val readUseCase: ReadUseCase<BaseProduct>): BaseViewModel(){

    val productList = MutableLiveData<List<BaseProduct>>()

    fun create(name:String, amount:Double){
        val product = productExist(name)
            if
                (product != null) createListItem(product, amount)
            else
                createProduct(name, amount)
    }

    fun loadProducts(){
        readUseCase.readAll(observer = BaseSingleObserver({ list -> productList.postValue(list)}, { disposable -> compositeDisposable.add(disposable)}))
    }

    private fun createProduct(name:String, amount: Double){
        val product = BaseProduct(name = name)
        createBaseProductUseCase.create(product,
                BaseSingleObserver({id -> val newProduct = BaseProduct(productID = id, name = name)
                    createListItem(newProduct, amount)}, {disposable -> compositeDisposable.add(disposable)}))
    }

    private fun createListItem(product:BaseProduct, amount:Double){
        product.productID?.let{ val item = ListItem(name = product.name, amount = amount, productId = it)
            createListItemUseCase.create(item, BaseSingleObserver({},{disposable -> compositeDisposable.add(disposable)}))
        }
    }

    private fun productExist(productName:String):BaseProduct? {
        productList.value?.let {
            for(item in it){
                if(item.name == productName) return item
            }
        }
        return null
    }
}