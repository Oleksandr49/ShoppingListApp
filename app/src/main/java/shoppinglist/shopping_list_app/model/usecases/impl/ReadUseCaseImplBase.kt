package shoppinglist.shopping_list_app.model.usecases.impl

import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleUseCase
import javax.inject.Inject

class ReadUseCaseImplBase <E,R: BaseRepository<E>>@Inject constructor(private val repository:R): BaseSingleUseCase<E>(), ReadUseCase<E> {

    override fun read(id: Long, observer: SingleObserver<E>) {
        repository.get(id).also { execute(it,observer) }
    }

    override fun readAll(observer: SingleObserver<List<E>>) {
        repository.getAll().also { executeForList(it,observer) }
    }
}