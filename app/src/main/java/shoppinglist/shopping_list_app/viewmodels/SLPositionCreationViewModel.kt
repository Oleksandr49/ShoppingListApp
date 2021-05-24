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


    /**
     * Creates new list position. If product exists connects it with new position,
     * else creates new product with given name.
     */
    fun create(name:String, amount:Double){
        val product = productExist(name)
            if
                (product != null) createListItem(product, amount)
            else
                createProduct(name, amount)
    }

    /**
     * Loads list of products and posts it for input autofill.
     */
    fun loadProducts(){
        Log.i("ProcessTag", "Loading existing products")
        readUseCase.readAll(observer = BaseSingleObserver({ list -> productList.postValue(list)}, { disposable -> compositeDisposable.add(disposable)}))
    }

    /**
     * Creates new product.
     */
    private fun createProduct(name:String, amount: Double){
        Log.i("ProcessTag", "Creating new product")
        val product = BaseProduct(name = name)
        createBaseProductUseCase.create(product,
                BaseSingleObserver({id -> val newProduct = BaseProduct(productID = id, name = name)
                    createListItem(newProduct, amount)
                    Log.i("ProcessTag", "Product created")}, {disposable -> compositeDisposable.add(disposable)}))
    }

    /**
     * Creates new list position.
     */
    private fun createListItem(product:BaseProduct, amount:Double){
        Log.i("ProcessTag", "Creating ListItem")
        product.productID?.let{ val item = ListItem(name = product.name, amount = amount, productId = it)
            createListItemUseCase.create(item, BaseSingleObserver({ Log.i("ProcessTag", "ListItem Created")},{disposable -> compositeDisposable.add(disposable)}))
        }
    }

    /**
     * Checks if product exists in already loaded productList.
     */
    private fun productExist(productName:String):BaseProduct? {
        Log.i("ProcessTag", "Check if product exists")
        productList.value?.let {
            for(item in it){
                if(item.name == productName) return item
            }
        }
        return null
    }
}