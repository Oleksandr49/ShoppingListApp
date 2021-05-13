package shoppinglist.shopping_list_app.model.repository

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.SLPosition

@Dao
interface SLPositionDAO {

    @Insert
    fun create(param: SLPosition): Completable

    @Query("DELETE FROM SLPositions WHERE positionID = :id")
    fun delete(id:Long): Completable

    @Update
    fun update(updated: SLPosition): Completable

    @Transaction
    @Query("SELECT * FROM SLPositions WHERE positionID = :id")
    fun get(id:Long): Single<SLPosition>

    @Transaction
    @Query("SELECT * FROM SLPositions")
    fun getAll(): Single<List<SLPosition>>

    @Query("DELETE FROM SLPositions")
    fun deleteAll(): Completable


}

