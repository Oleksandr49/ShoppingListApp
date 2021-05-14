package shoppinglist.shopping_list_app.model.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface CartItemDao: BaseDao<CartItem> {

    @Insert
     override fun create(param: CartItem): Completable
    @Query("DELETE FROM CartItems WHERE id = :id")
     override fun delete(id: Long): Completable
    @Query("DELETE FROM CartItems")
     override fun deleteAll(): Completable
    @Update
     override fun update(updated: CartItem): Completable
    @Query("SELECT * FROM CartItems WHERE id = :id")
     override fun get(id: Long): Single<CartItem>
    @Query("SELECT * FROM CartItems")
     override fun getAll(): Single<List<CartItem>>
}