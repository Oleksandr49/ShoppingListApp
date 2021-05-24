package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.Single
import io.reactivex.SingleObserver

abstract class BaseSingleUseCase<E>:BaseUseCase() {

     protected fun execute(observable: Single<E>, observer: SingleObserver<E>){
        observable.subscribeOn(threadExecutorScheduler).observeOn(postExecutionThreadScheduler).subscribe(observer)
    }

    protected fun executeForList(observable: Single<List<E>>, observer: SingleObserver<List<E>>){
        observable.subscribeOn(threadExecutorScheduler).observeOn(postExecutionThreadScheduler).subscribe(observer)
    }

    protected fun executeNotObserve(observable: Single<E>, observer: SingleObserver<E>){
        observable.subscribeOn(threadExecutorScheduler).subscribe(observer)
    }
}