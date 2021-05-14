package shoppinglist.shopping_list_app.model.usecases

import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseDao
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.BaseUseCase
import shoppinglist.shopping_list_app.model.usecases.base.CompletableUseCase
import javax.inject.Inject

class UpdateUseCase<E,D: BaseDao<E>,R: BaseRepository<E,D>>@Inject constructor(private val repository:R ): CompletableUseCase() {

    fun update(param: E, observer: CompletableObserver) = repository.update(param).also { execute(it, observer) }
}