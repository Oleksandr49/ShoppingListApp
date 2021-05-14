package shoppinglist.shopping_list_app.model.usecases

import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseDao
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.SingleUseCase
import javax.inject.Inject

class GetOneUseCase <E,D: BaseDao<E>,R: BaseRepository<E,D>>@Inject constructor(private val repository:R): SingleUseCase<E>() {

    fun getOne(id:Long, observer:SingleObserver<E>) = repository.get(id).also { execute(it, observer) }

}