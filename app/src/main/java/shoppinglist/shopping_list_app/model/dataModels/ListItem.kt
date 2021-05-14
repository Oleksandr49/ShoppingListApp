package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.Entity

@Entity(tableName = "ListItems")
class ListItem(id:Long? = null, productId:Long, name:String, amount:Double):BaseItem(id, productId, name, amount)