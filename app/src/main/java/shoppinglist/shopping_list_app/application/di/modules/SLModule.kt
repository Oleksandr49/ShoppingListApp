package shoppinglist.shopping_list_app.application.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.SLViewModel

@Module
abstract class SLModule {

    @Binds
    @IntoMap
    @ViewModelKey(SLViewModel::class)
    abstract fun bindViewModel(viewModel: SLViewModel): ViewModel
}