package shoppinglist.shopping_list_app.model.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.dataModels.relations.CartToCartItems
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface CartDao: BaseDao<Cart> {

    @Query("DELETE FROM Carts WHERE cartId = :id")
     override  fun delete(id: Long): Completable
    @Query("DELETE FROM Carts")
     override  fun deleteAll(): Completable
    @Query("SELECT * FROM Carts WHERE cartId = :id")
     override  fun get(id: Long): Single<Cart>
    @Query("SELECT * FROM Carts")
     override  fun getAll(): Single<List<Cart>>

     @Transaction
    @Query("SELECT * FROM Carts")
    fun getAllCartsWithItems(): Single<List<CartToCartItems>>
    @Transaction
    @Query("SELECT * FROM Carts WHERE cartId = :id")
    fun getCartWithItems(id: Long): Single<List<CartToCartItems>>
}