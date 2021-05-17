package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.SingleObserver

interface ReadUseCase<E>{
    
    fun read(id:Long, observer:SingleObserver<E>)
    fun readAll(observer: SingleObserver<List<E>>)
}