package shoppinglist.shopping_list_app.application.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import shoppinglist.shopping_list_app.viewmodels.ProductCreationViewModel

@Module
abstract class ProductCreationModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductCreationViewModel::class)
    abstract fun bindViewModel(viewModel: ProductCreationViewModel): ViewModel
}