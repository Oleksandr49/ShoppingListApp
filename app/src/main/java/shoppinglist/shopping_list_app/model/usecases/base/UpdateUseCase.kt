package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.CompletableObserver

interface UpdateUseCase<E> {
    
    fun update(entity:E, observer:CompletableObserver)
}