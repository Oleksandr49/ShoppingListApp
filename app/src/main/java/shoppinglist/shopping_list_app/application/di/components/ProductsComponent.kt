package shoppinglist.shopping_list_app.application.di.components

import dagger.Subcomponent
import shoppinglist.shopping_list_app.application.di.modules.ProductsModule
import shoppinglist.shopping_list_app.views.fragments.ProductsListFragment

@Subcomponent(modules = [ProductsModule::class])
interface ProductsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): ProductsComponent
    }

    fun inject(fragment: ProductsListFragment)
}