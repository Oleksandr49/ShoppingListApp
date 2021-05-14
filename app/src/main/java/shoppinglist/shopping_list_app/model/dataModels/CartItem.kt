package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.Entity


@Entity(tableName = "CartItems")
class CartItem(id:Long, productId:Long, name:String, amount:Double, var cartId:Long):BaseItem(id, productId, name, amount)