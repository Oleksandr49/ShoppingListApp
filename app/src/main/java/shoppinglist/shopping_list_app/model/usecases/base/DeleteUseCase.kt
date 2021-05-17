package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.CompletableObserver

interface DeleteUseCase<E> {
    
    fun delete(id:Long, observer:CompletableObserver)
    fun deleteAll(observer:CompletableObserver)
}