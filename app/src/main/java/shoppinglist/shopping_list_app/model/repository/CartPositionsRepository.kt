package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.CartPosition
import javax.inject.Inject

class CartPositionsRepository @Inject constructor(private val dao:CartPositionDAO): BaseRepository<CartPosition> {

    override fun create(param: CartPosition) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: CartPosition) = dao.update(updated)

    override fun get(id: Long)= dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()
}