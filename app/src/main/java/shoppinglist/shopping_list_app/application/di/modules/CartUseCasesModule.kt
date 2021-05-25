package shoppinglist.shopping_list_app.application.di.modules

import dagger.Binds
import dagger.Module
import shoppinglist.shopping_list_app.model.dataModels.Cart
import shoppinglist.shopping_list_app.model.dataModels.relations.CartToCartItems
import shoppinglist.shopping_list_app.model.repository.CartRep
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import shoppinglist.shopping_list_app.model.usecases.impl.*

@Module
abstract class CartUseCasesModule {

    @Binds
    abstract fun bindCreateUseCase(useCase: CreateUseCaseImplBase<Cart, CartRep>): CreateUseCase<Cart>
    @Binds
    abstract fun bindDeleteUseCase(useCase: DeleteUseCaseImplBase<Cart, CartRep>): DeleteUseCase<Cart>
    @Binds
    abstract fun bindUpdateUseCase(useCase: UpdateUseCaseImplBase<Cart, CartRep>): UpdateUseCase<Cart>
    @Binds
    abstract fun bindReadUseCase(useCase: ReadUseCaseImplBase<Cart, CartRep>): ReadUseCase<Cart>
    @Binds
    abstract fun bindReadCartWithItemsUseCase(useCase: ReadCartWithItemsUseCase): ReadUseCase<CartToCartItems>
}