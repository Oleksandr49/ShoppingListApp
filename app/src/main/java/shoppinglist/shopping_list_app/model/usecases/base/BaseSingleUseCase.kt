package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.Single
import io.reactivex.SingleObserver

abstract class BaseSingleUseCase<S>:BaseUseCase() {

     protected fun execute(observable: Single<S>, observer: SingleObserver<S>){
        observable.subscribeOn(threadExecutorScheduler).observeOn(postExecutionThreadScheduler).subscribe(observer)
    }

    protected fun executeForList(observable: Single<List<S>>, observer: SingleObserver<List<S>>){
        observable.subscribeOn(threadExecutorScheduler).observeOn(postExecutionThreadScheduler).subscribe(observer)
    }
}