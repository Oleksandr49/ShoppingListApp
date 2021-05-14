package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import javax.inject.Inject

class CartItemsRep @Inject constructor(dao:CartItemDao):BaseRepository<CartItem, CartItemDao>(dao)