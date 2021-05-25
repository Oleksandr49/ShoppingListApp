package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.repository.dao.CartDao
import javax.inject.Inject

class CartRep @Inject constructor(val dao: CartDao) : BaseRepository<Cart>{

    override fun create(param: Cart) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: Cart) = dao.update(updated)

    override fun get(id: Long) = dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()

    fun getAllCartsWithItems() = dao.getAllCartsWithItems()

    fun getCartWithItems(id: Long) = dao.getCartWithItems(id)

}