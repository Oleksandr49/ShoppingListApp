package shoppinglist.shopping_list_app.model.usecases.base

import io.reactivex.Single
import io.reactivex.SingleObserver

abstract class SingleUseCase<S>:BaseUseCase() {

    protected fun execute(observable: Single<S>, observer: SingleObserver<S>){
        observable.subscribeOn(threadExecutorScheduler).observeOn(postExecutionThreadScheduler).subscribe(observer)
    }
}