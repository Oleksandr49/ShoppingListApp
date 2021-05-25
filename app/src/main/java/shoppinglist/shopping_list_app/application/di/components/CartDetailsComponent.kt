package shoppinglist.shopping_list_app.application.di.components

import dagger.Subcomponent
import shoppinglist.shopping_list_app.application.di.modules.CartDetailsModule
import shoppinglist.shopping_list_app.views.fragments.CartDetailsFragment

@Subcomponent(modules = [CartDetailsModule::class])
interface CartDetailsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): CartDetailsComponent
    }

    fun inject(fragment: CartDetailsFragment)
}