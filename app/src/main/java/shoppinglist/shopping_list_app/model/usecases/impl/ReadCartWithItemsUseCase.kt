package shoppinglist.shopping_list_app.model.usecases.impl

import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.dataModels.relations.CartToCartItems
import shoppinglist.shopping_list_app.model.repository.CartRep
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import javax.inject.Inject

class ReadCartWithItemsUseCase @Inject constructor(private val repository:CartRep): BaseSingleUseCase<CartToCartItems>(), ReadUseCase<CartToCartItems> {

    override fun read(id: Long, observer: SingleObserver<CartToCartItems>) {
        repository.getCartWithItems(id).also { execute(it, observer) }
    }

    override fun readAll(observer: SingleObserver<List<CartToCartItems>>) {
        repository.getAllCartsWithItems().also { executeForList(it, observer) }
    }
}