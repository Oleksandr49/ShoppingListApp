package shoppinglist.shopping_list_app.model.usecases.impl

import io.reactivex.CompletableObserver
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableUseCase
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import javax.inject.Inject

class DeleteUseCaseImplBase <E,R: BaseRepository<E>> @Inject constructor(private val repository:R): BaseCompletableUseCase(), DeleteUseCase<E>  {

     override fun delete(id: Long, observer: CompletableObserver) {
          repository.delete(id).also { execute(it, observer) }
     }

     override fun deleteAll(observer: CompletableObserver) {
      repository.deleteAll().also { execute(it, observer) }
     }

}