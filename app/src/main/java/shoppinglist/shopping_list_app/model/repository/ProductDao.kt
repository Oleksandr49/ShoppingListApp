package shoppinglist.shopping_list_app.model.repository

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.dataModels.relations.CartToCartItems
import shoppinglist.shopping_list_app.model.dataModels.relations.ProductToItems
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface ProductDao: BaseDao<BaseProduct> {

    @Insert
     override fun create(param: BaseProduct): Completable

    @Query("DELETE FROM products WHERE productID = :id")
     override fun delete(id:Long): Completable

    @Update
     override fun update(updated: BaseProduct): Completable

    @Query("SELECT * FROM products WHERE productID = :id")
     override fun get(id:Long): Single<BaseProduct>

    @Query("SELECT * FROM products")
     override fun getAll(): Single<List<BaseProduct>>

    @Query("DELETE FROM products")
     override fun deleteAll(): Completable

    @Transaction
    @Query("SELECT * FROM Products")
    fun getAllProductsWithItems(): Single<List<ProductToItems>>

    @Transaction
    @Query("SELECT * FROM Products WHERE productID = :id")
    fun getProductWithItems(id: Long): Single<List<ProductToItems>>

}
