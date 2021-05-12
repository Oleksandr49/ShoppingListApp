package shoppinglist.shopping_list_app.model.usecases

import android.util.Log
import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.BaseRepository
import javax.inject.Inject

class DeletionUseCase <R:BaseRepository<D>, D>@Inject constructor(private val repository:R): BaseUseCase<Long, CompletableObserver>() {

    override fun execute(param: Long?, observer: CompletableObserver) {
        param?.let {repository.delete(it)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
            .subscribe(observer)}
    }
}