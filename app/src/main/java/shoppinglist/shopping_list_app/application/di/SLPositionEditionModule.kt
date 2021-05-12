package shoppinglist.shopping_list_app.application.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.SLPositionEditionViewModel

@Module
abstract class SLPositionEditionModule {

    @Binds
    @IntoMap
    @ViewModelKey(SLPositionEditionViewModel::class)
    abstract fun bindViewModel(viewModel: SLPositionEditionViewModel): ViewModel
}