package shoppinglist.shopping_list_app.model.dataModels.relations

import androidx.room.Embedded
import androidx.room.Relation
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.dataModels.CartItem

class CartToCartItems(@Embedded
                      val cart:Cart,
                      @Relation(parentColumn = "cartId", entityColumn = "cartId")
                      val cartItems:List<CartItem>) {
}