package shoppinglist.shopping_list_app.application.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.SLPositionCreationViewModel

@Module
abstract class SLPositionCreationModule {

    @Binds
    @IntoMap
    @ViewModelKey(SLPositionCreationViewModel::class)
    abstract fun bindViewModel(viewModel: SLPositionCreationViewModel): ViewModel
}