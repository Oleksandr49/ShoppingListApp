package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BaseItems")
open class BaseItem(@PrimaryKey(autoGenerate = true)val id: Long? = null,
                    @ColumnInfo(name = "productID")var productId:Long,
                        @ColumnInfo(name = "name")var name: String,
                        @ColumnInfo(name = "amount")var amount: Double)