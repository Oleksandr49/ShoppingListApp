package shoppinglist.shopping_list_app.model.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.SLPosition

@Dao
interface SLPositionDAO {

    @Insert
    fun create(param: SLPosition): Completable

    @Query("DELETE FROM SLPositions WHERE id = :id")
    fun delete(id:Long): Completable

    @Update
    fun update(updated: SLPosition): Completable

    @Query("SELECT * FROM SLPositions WHERE id = :id")
    fun get(id:Long): Single<SLPosition>

    @Query("SELECT * FROM SLPositions")
    fun getAll(): Single<List<SLPosition>>

    @Query("DELETE FROM SLPositions")
    fun deleteAll(): Completable
}

