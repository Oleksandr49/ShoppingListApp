package shoppinglist.shopping_list_app.application.di.components

import dagger.Subcomponent
import shoppinglist.shopping_list_app.application.di.modules.CartModule
import shoppinglist.shopping_list_app.views.fragments.CartFragment

@Subcomponent(modules = [CartModule::class])
interface CartComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): CartComponent
    }

    fun inject(fragment: CartFragment)
}