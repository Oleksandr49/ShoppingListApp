package shoppinglist.shopping_list_app.model.usecases

import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseDao
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.BaseUseCase
import shoppinglist.shopping_list_app.model.usecases.base.SingleUseCase
import javax.inject.Inject

class GetAllUseCase <E,D:BaseDao<E>,R: BaseRepository<E,D>>@Inject constructor(private val repository:R): SingleUseCase<List<E>>() {

    fun getAll(observer: SingleObserver<List<E>>) = repository.getAll().also { execute(it,observer) }
}