package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Carts")
class Cart(@PrimaryKey(autoGenerate = true)val cartId:Long? = null, var date:String){
}