package shoppinglist.shopping_list_app.model.repository.base

import androidx.room.Dao

import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BaseDao<E> {

     fun create(param: E): Completable
     fun delete(id:Long): Completable
     fun deleteAll(): Completable
     fun update(updated: E): Completable
     fun get(id:Long): Single<E>
     fun getAll(): Single<List<E>>
}