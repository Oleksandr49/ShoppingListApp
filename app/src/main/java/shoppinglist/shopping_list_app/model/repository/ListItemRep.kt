package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.repository.dao.ListItemDao
import javax.inject.Inject

class ListItemRep @Inject constructor(val dao: ListItemDao): BaseRepository<ListItem>{

    override fun create(param: ListItem) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: ListItem) = dao.update(updated)

    override fun get(id: Long) = dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()
}