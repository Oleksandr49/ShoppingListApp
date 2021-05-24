package shoppinglist.shopping_list_app.model.repository.base

import androidx.room.Database
import androidx.room.RoomDatabase
import shoppinglist.shopping_list_app.model.dataModels.*
import shoppinglist.shopping_list_app.model.repository.dao.CartDao
import shoppinglist.shopping_list_app.model.repository.dao.CartItemDao
import shoppinglist.shopping_list_app.model.repository.dao.ListItemDao
import shoppinglist.shopping_list_app.model.repository.dao.ProductDao

@Database(entities = [BaseItem::class, CartItem::class, BaseProduct::class, Cart::class, ListItem::class], version = 1, exportSchema = false)
abstract class BaseDataBase: RoomDatabase() {

    abstract fun listItemDao(): ListItemDao
    abstract fun cartItemDao(): CartItemDao
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
}