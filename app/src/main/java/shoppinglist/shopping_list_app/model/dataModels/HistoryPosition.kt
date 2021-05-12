package shoppinglist.shopping_list_app.model.dataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "History_positions")
data class HistoryPosition (@PrimaryKey(autoGenerate = true) var ID:Long? = null,
                            @ColumnInfo(name = "Date")var date: Date,
                            @ColumnInfo(name = "Items ")val cartPositions: ArrayList<CartPosition> = ArrayList()) {
}

