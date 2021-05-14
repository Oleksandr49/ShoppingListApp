package shoppinglist.shopping_list_app.application.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.CartFragmentViewModel

@Module
abstract class CartModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartFragmentViewModel::class)
    abstract fun bindViewModel(viewModel: CartFragmentViewModel): ViewModel
}