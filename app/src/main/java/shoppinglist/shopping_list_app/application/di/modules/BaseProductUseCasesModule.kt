package shoppinglist.shopping_list_app.application.di.modules

import dagger.Binds
import dagger.Module
import shoppinglist.shopping_list_app.model.dataModels.BaseProduct
import shoppinglist.shopping_list_app.model.repository.ProductsRep
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import shoppinglist.shopping_list_app.model.usecases.impl.CreateUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.DeleteUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.ReadUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.UpdateUseCaseImplBase

@Module
abstract class BaseProductUseCasesModule {

    @Binds
    abstract fun bindCreateUseCase(useCase: CreateUseCaseImplBase<BaseProduct, ProductsRep>): CreateUseCase<BaseProduct>
    @Binds
    abstract fun bindDeleteUseCase(useCase: DeleteUseCaseImplBase<BaseProduct, ProductsRep>): DeleteUseCase<BaseProduct>
    @Binds
    abstract fun bindUpdateUseCase(useCase: UpdateUseCaseImplBase<BaseProduct, ProductsRep>): UpdateUseCase<BaseProduct>
    @Binds
    abstract fun bindReadUseCase(useCase: ReadUseCaseImplBase<BaseProduct, ProductsRep>): ReadUseCase<BaseProduct>
}