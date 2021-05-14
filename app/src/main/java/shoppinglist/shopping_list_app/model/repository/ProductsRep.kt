package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import javax.inject.Inject

class ProductsRep @Inject constructor(dao:ProductDao): BaseRepository<BaseProduct, ProductDao>(dao) {

}