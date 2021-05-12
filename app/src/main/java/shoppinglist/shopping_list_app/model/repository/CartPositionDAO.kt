package shoppinglist.shopping_list_app.model.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.CartPosition

@Dao
interface CartPositionDAO {

    @Insert
    fun create(param: CartPosition): Completable

    @Query("DELETE FROM CartPositions WHERE id = :id")
    fun delete(id:Long): Completable

    @Query("DELETE FROM CartPositions")
    fun deleteAll(): Completable

    @Update
    fun update(updated: CartPosition): Completable

    @Query("SELECT * FROM CartPositions WHERE id = :id")
    fun get(id:Long): Single<CartPosition>

    @Query("SELECT * FROM CartPositions")
    fun getAll(): Single<List<CartPosition>>
}