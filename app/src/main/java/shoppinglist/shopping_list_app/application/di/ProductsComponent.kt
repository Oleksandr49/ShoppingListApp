package shoppinglist.shopping_list_app.application.di

import androidx.fragment.app.Fragment
import dagger.Subcomponent
import shoppinglist.shopping_list_app.views.fragments.ProductsListFragment

@Subcomponent(modules = [CartModule::class])
interface ProductsComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ProductsComponent
    }

    fun inject(fragment: ProductsListFragment)
}