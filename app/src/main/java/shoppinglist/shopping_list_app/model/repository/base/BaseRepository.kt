package shoppinglist.shopping_list_app.model.repository.base

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface BaseRepository<T> {

    fun create(param:T) : Single<Long>
    fun delete(id:Long) : Completable
    fun update(updated:T) : Completable
    fun get(id:Long) : Single<T>
    fun getAll() : Single<List<T>>
    fun deleteAll() : Completable

}