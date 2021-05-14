package shoppinglist.shopping_list_app.model.repository

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.BaseItem
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.base.BaseDao

@Dao
interface ListItemDao: BaseDao<ListItem>{

    @Insert
    override fun create(param: ListItem): Completable
    @Query("DELETE FROM ListItems WHERE id = :id")
    override fun delete(id: Long): Completable
    @Query("DELETE FROM ListItems")
    override fun deleteAll(): Completable
    @Update
    override fun update(updated: ListItem): Completable
    @Query("SELECT * FROM ListItems WHERE id = :id")
    override fun get(id: Long): Single<ListItem>
    @Query("SELECT * FROM ListItems")
    override fun getAll(): Single<List<ListItem>>
}

