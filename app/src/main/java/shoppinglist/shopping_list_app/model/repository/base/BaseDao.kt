package shoppinglist.shopping_list_app.model.repository.base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BaseDao<E> {

     @Insert
     fun create(param: E): Single<Long>
     fun delete(id:Long): Completable
     fun deleteAll(): Completable
     @Update
     fun update(updated: E): Completable
     fun get(id:Long): Single<E>
     fun getAll(): Single<List<E>>
}