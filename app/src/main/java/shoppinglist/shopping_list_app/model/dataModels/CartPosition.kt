package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CartPositions")
data class CartPosition(@PrimaryKey(autoGenerate = true) var ID: Long? = null,
                   @ColumnInfo(name = "product_name")var productName: String,
                   @ColumnInfo(name = "product_amount")var productAmount: Double) {
}