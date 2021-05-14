package shoppinglist.shopping_list_app.model.repository

import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.base.BaseRepository
import javax.inject.Inject

class ListItemRep @Inject constructor(dao:ListItemDao): BaseRepository<ListItem, ListItemDao>(dao)