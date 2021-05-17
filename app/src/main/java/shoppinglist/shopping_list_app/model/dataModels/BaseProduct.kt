package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
open class BaseProduct(@PrimaryKey(autoGenerate = true) val productID:Long? = null,
                       @ColumnInfo(name = "Name") var name:String,
                       @ColumnInfo(name = "AmountType") var type:Int? = null ) {
}