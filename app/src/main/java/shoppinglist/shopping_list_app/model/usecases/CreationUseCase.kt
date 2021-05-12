package shoppinglist.shopping_list_app.model.usecases

import android.util.Log
import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.BaseRepository
import javax.inject.Inject

class CreationUseCase <R: BaseRepository<D>, D> @Inject constructor(private val repository:R ): BaseUseCase<D, CompletableObserver>() {

    override fun execute(param: D?, observer: CompletableObserver) {
        param?.let {repository.create(it)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
            .subscribe(observer)}
    }
}