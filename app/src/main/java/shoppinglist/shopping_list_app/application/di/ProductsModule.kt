package shoppinglist.shopping_list_app.application.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.CartFragmentViewModel
import shoppinglist.shopping_list_app.viewmodels.ProductsViewModel

@Module
abstract class ProductsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindViewModel(viewModel: ProductsViewModel): ViewModel
}