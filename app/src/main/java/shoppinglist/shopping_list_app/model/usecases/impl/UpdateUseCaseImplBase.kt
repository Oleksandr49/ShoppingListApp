package shoppinglist.shopping_list_app.model.usecases.impl

import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import javax.inject.Inject

class UpdateUseCaseImplBase<E,R: BaseRepository<E>>@Inject constructor(private val repository:R ): BaseCompletableUseCase(), UpdateUseCase<E> {

    override fun update(entity: E, observer: CompletableObserver) {
        repository.update(entity).also { execute(it, observer) }}
}