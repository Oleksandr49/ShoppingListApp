package shoppinglist.shopping_list_app.model.dataModels.relations

import androidx.room.Embedded
import androidx.room.Relation
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.dataModels.ListItem

class ProductToItems(@Embedded
                     var product:BaseProduct,
                     @Relation(parentColumn = "productID", entityColumn = "productID")
                     var items: List<ListItem>) {
}