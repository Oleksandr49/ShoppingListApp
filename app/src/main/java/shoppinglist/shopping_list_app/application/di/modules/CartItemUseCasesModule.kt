package shoppinglist.shopping_list_app.application.di.modules

import dagger.Binds
import dagger.Module
import shoppinglist.shopping_list_app.model.dataModels.CartItem
import shoppinglist.shopping_list_app.model.repository.CartItemsRep
import shoppinglist.shopping_list_app.model.usecases.base.*
import shoppinglist.shopping_list_app.model.usecases.impl.*

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
    @Binds
    abstract fun bindReadWithConditionUseCase(useCase: ReadListAllCartItemsWithoutCartUseCase): ReadListWithConditionUseCase<CartItem>
}