package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import shoppinglist.shopping_list_app.model.repository.dao.ProductDao
import javax.inject.Inject

class ProductsRep @Inject constructor(val dao: ProductDao): BaseRepository<BaseProduct> {

    override fun create(param: BaseProduct) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: BaseProduct) = dao.update(updated)

    override fun get(id: Long) = dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()

}