package shoppinglist.shopping_list_app.application.di

import dagger.Subcomponent
import shoppinglist.shopping_list_app.views.fragments.SLFragment

@Subcomponent(modules = [SLModule::class])
interface SLComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():SLComponent
    }

    fun inject(fragment: SLFragment)
}