package shoppinglist.shopping_list_app.model.repository.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface CartItemDao: BaseDao<CartItem> {

    @Query("DELETE FROM CartItems WHERE id = :id")
     override fun delete(id: Long): Completable
    @Query("DELETE FROM CartItems")
     override fun deleteAll(): Completable
    @Query("SELECT * FROM CartItems WHERE id = :id")
     override fun get(id: Long): Single<CartItem>
    @Query("SELECT * FROM CartItems")
     override fun getAll(): Single<List<CartItem>>
     @Query("SELECT * FROM CartItems WHERE cartId = 0")
     fun getAllWithoutCart(): Single<List<CartItem>>
}