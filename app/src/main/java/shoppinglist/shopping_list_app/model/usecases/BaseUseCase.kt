package shoppinglist.shopping_list_app.model.usecases

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase <P, O> {

    protected open val threadExecutorScheduler: Scheduler = Schedulers.io()

    protected open val postExecutionThreadScheduler: Scheduler = AndroidSchedulers.mainThread()

    abstract fun execute(param:P? = null, observer:O)

}