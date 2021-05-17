package shoppinglist.shopping_list_app.model.usecases.impl
import io.reactivex.SingleObserver

import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleUseCase
import javax.inject.Inject

class CreateUseCaseImplBase <E,R: BaseRepository<E>> @Inject constructor(private val repository:R ): BaseSingleUseCase<Long>(), CreateUseCase<E> {

     override fun create(entity: E, observer: SingleObserver<Long>) {
          repository.create(entity).also { execute(it, observer) }
     }

}