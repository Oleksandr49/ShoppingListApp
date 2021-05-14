package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import javax.inject.Inject

class CartRep @Inject constructor(dao: CartDao) : BaseRepository<Cart, CartDao>(dao)