package shoppinglist.shopping_list_app.application.di.components

import dagger.Subcomponent
import shoppinglist.shopping_list_app.application.di.modules.ProductCreationModule
import shoppinglist.shopping_list_app.views.fragments.ProductCreationFragment

@Subcomponent(modules = [ProductCreationModule::class])
interface ProductCreationComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ProductCreationComponent
    }

    fun inject(fragment:ProductCreationFragment)
}