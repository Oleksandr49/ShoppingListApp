package shoppinglist.shopping_list_app.application.di.components

import dagger.Subcomponent
import shoppinglist.shopping_list_app.application.di.modules.HistoryModule
import shoppinglist.shopping_list_app.views.fragments.ShoppingHistoryFragment

@Subcomponent(modules = [HistoryModule::class])
interface HistoryComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): HistoryComponent
    }

    fun inject(fragment: ShoppingHistoryFragment)
}