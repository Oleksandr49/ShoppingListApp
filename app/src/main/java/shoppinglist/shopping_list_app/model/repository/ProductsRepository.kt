package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.Product
import javax.inject.Inject

class ProductsRepository@Inject constructor(private val dao:ProductDAO): BaseRepository<Product> {

    override fun create(param: Product) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: Product) = dao.update(updated)

    override fun get(id: Long)= dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()
}