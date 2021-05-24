package shoppinglist.shopping_list_app.model.usecases.impl

import android.util.Log
import io.reactivex.SingleObserver
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.CartItemsRep
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadListWithConditionUseCase
import javax.inject.Inject

class ReadListAllCartItemsWithoutCartUseCase @Inject constructor(val repository:CartItemsRep): BaseSingleUseCase<CartItem>(), ReadListWithConditionUseCase<CartItem> {

    override fun readListWithCondition(observer: SingleObserver<List<CartItem>>) {
        repository.getAllWithoutCart().also { executeForList(it, observer) }
    }
}