package shoppinglist.shopping_list_app.model.usecases

import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.BaseRepository
import javax.inject.Inject

class UpdateUseCase<R:BaseRepository<Any>, D>@Inject constructor(private val repository:R ): BaseUseCase<D, CompletableObserver>() {

    override fun execute(param: D?, observer: CompletableObserver) {
        param?.let {repository.update(it)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
            .subscribe(observer)}
    }
}