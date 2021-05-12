package shoppinglist.shopping_list_app.application.di

import dagger.Subcomponent
import shoppinglist.shopping_list_app.views.fragments.SLPositionEdition

@Subcomponent(modules = [SLPositionEditionModule::class])
interface SLPositionEditionComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():SLPositionEditionComponent
    }

    fun inject(fragment: SLPositionEdition)
}