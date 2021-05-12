package shoppinglist.shopping_list_app.model.usecases

import android.util.Log
import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.repository.BaseRepository
import javax.inject.Inject

class GetAllUseCase <R: BaseRepository<D>, D>@Inject constructor(private val repository:R): BaseUseCase<D, SingleObserver<List<D>>>() {

    override fun execute(param: D?, observer: SingleObserver<List<D>>) {
        repository.getAll()
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
            .subscribe(observer)
    }
}