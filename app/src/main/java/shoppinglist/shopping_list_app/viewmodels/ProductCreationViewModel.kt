package shoppinglist.shopping_list_app.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import shoppinglist.shopping_list_app.model.dataModels.AmountType
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class ProductCreationViewModel @Inject constructor(private val creationUseCase: CreateUseCase<BaseProduct>,
                                                   private val readUseCase: ReadUseCase<BaseProduct>
): BaseViewModel() {

    val productList = MutableLiveData<List<BaseProduct>>()

    /**
     * Creates new list position. If product exists connects it with new position,
     * else creates new product with given name.
     */
    fun create(name:String, type:AmountType?){
        val doExist = productExist(name)
        if
                (doExist) Log.i("temp", "Exist")
        else
            createProduct(name, type)
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
    private fun createProduct(name:String, type: AmountType?){
        Log.i("ProcessTag", "Creating new product")
        val product = BaseProduct(name = name, type = determineType(type))
        creationUseCase.create(product,
            BaseSingleObserver({id -> Log.i("ProcessTag", "created $id")}, { disposable -> compositeDisposable.add(disposable)})
        )
    }

    /**
     * Checks if product exists in already loaded productList.
     */
    private fun productExist(productName:String):Boolean {
        Log.i("ProcessTag", "Check if product with name:$productName exists")
        productList.value?.let {
            Log.i("ProcessTag", "List size = ${it.size}")
            for(item in it){
                if(item.name == productName) return true
            }
        }
        return false
    }

    private fun determineType(type:AmountType?): String?{
        return when(type){
            AmountType.L -> "l"
            AmountType.KG -> "kg"
            AmountType.PACK -> "pck"
            AmountType.ITEM -> "itm"
            else -> null
        }
    }
}