package shoppinglist.shopping_list_app.model.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.Product

@Dao
interface ProductDAO {

    @Insert
    fun create(param: Product): Completable

    @Query("DELETE FROM products WHERE productID = :id")
    fun delete(id:Long): Completable

    @Update
    fun update(updated: Product): Completable

    @Query("SELECT * FROM products WHERE productID = :id")
    fun get(id:Long): Single<Product>

    @Query("SELECT * FROM products")
    fun getAll(): Single<List<Product>>

    @Query("DELETE FROM products")
    fun deleteAll(): Completable

}
