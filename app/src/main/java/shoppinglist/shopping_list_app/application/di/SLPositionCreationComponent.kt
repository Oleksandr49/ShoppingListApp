package shoppinglist.shopping_list_app.application.di

import dagger.Subcomponent
import shoppinglist.shopping_list_app.views.fragments.SLPositionCreation

@Subcomponent(modules = [SLPositionCreationModule::class])
interface SLPositionCreationComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():SLPositionCreationComponent
    }

    fun inject(fragment: SLPositionCreation)
}