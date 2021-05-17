package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.SingleObserver


interface CreateUseCase<E>{
    
    fun create(entity:E, observer:SingleObserver<Long>)
}