package shoppinglist.shopping_list_app.model.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface ListItemDao: BaseDao<ListItem> {

    @Query("DELETE FROM ListItems WHERE id = :id")
    override fun delete(id: Long): Completable
    @Query("DELETE FROM ListItems")
    override fun deleteAll(): Completable
    @Query("SELECT * FROM ListItems WHERE id = :id")
    override fun get(id: Long): Single<ListItem>
    @Query("SELECT * FROM ListItems")
    override fun getAll(): Single<List<ListItem>>
}

