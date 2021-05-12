package shoppinglist.shopping_list_app.model.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import shoppinglist.shopping_list_app.model.dataModels.CartPosition
import shoppinglist.shopping_list_app.model.dataModels.SLPosition

@Database(entities = [SLPosition::class, CartPosition::class], version = 2, exportSchema = false)
abstract class BaseDataBase: RoomDatabase() {

    abstract fun SLPositionDAO(): SLPositionDAO
    abstract fun CartPositionDAO(): CartPositionDAO
}