package shoppinglist.shopping_list_app.application.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.HistoryViewModel

@Module
abstract class HistoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindViewModel(viewModel: HistoryViewModel): ViewModel
}