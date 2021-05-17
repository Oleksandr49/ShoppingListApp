package shoppinglist.shopping_list_app.application.di.modules

import dagger.Binds
import dagger.Module
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.CartItemsRep
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import shoppinglist.shopping_list_app.model.usecases.impl.CreateUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.DeleteUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.ReadUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.UpdateUseCaseImplBase

@Module
abstract class CartItemUseCasesModule {

    @Binds
    abstract fun bindCreateUseCase(useCase: CreateUseCaseImplBase<CartItem, CartItemsRep>): CreateUseCase<CartItem>
    @Binds
    abstract fun bindDeleteUseCase(useCase: DeleteUseCaseImplBase<CartItem, CartItemsRep>): DeleteUseCase<CartItem>
    @Binds
    abstract fun bindUpdateUseCase(useCase: UpdateUseCaseImplBase<CartItem, CartItemsRep>): UpdateUseCase<CartItem>
    @Binds
    abstract fun bindReadUseCase(useCase: ReadUseCaseImplBase<CartItem, CartItemsRep>): ReadUseCase<CartItem>
}