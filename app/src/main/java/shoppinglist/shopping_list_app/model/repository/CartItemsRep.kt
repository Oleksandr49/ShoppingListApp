package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.repository.dao.CartItemDao
import javax.inject.Inject

class CartItemsRep @Inject constructor(val dao: CartItemDao):BaseRepository<CartItem>{

    override fun create(param: CartItem) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: CartItem) = dao.update(updated)

    override fun get(id: Long) = dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()
}