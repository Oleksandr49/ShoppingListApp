package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.Entity


@Entity(tableName = "CartItems")
class CartItem(id:Long? = null, productId:Long, name:String, amount:Double, var cartId:Long? = null):BaseItem(id, productId, name, amount)