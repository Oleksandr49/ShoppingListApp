package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.SingleObserver

interface ReadListWithConditionUseCase<E>{

    fun readListWithCondition(observer: SingleObserver<List<E>>)
}