package shoppinglist.shopping_list_app.application.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.CartDetailsViewModel

@Module
abstract class CartDetailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(CartDetailsViewModel::class)
    abstract fun bindViewModel(viewModel: CartDetailsViewModel): ViewModel
}