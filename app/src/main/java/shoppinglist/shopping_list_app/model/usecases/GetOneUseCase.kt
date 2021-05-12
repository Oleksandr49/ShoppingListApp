package shoppinglist.shopping_list_app.model.usecases

import android.util.Log
import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.repository.BaseRepository
import javax.inject.Inject

class GetOneUseCase <R: BaseRepository<D>, D>@Inject constructor(private val repository:R): BaseUseCase<Long, SingleObserver<D>>() {

    override fun execute(param: Long?, observer: SingleObserver<D>) {
        param?.let { repository.get(it)
                .subscribeOn(threadExecutorScheduler)
                .observeOn(postExecutionThreadScheduler)
                .subscribe(observer)
        }
    }
}