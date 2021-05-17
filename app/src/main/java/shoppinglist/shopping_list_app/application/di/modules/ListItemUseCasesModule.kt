package shoppinglist.shopping_list_app.application.di.modules

import dagger.Binds
import dagger.Module
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.ListItemRep
import shoppinglist.shopping_list_app.model.usecases.base.CreateUseCase
import shoppinglist.shopping_list_app.model.usecases.base.DeleteUseCase
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import shoppinglist.shopping_list_app.model.usecases.impl.CreateUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.DeleteUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.ReadUseCaseImplBase
import shoppinglist.shopping_list_app.model.usecases.impl.UpdateUseCaseImplBase

@Module
abstract class ListItemUseCasesModule {

    @Binds
    abstract fun bindCreateUseCase(useCase:CreateUseCaseImplBase<ListItem, ListItemRep>):CreateUseCase<ListItem>
    @Binds
    abstract fun bindDeleteUseCase(useCase:DeleteUseCaseImplBase<ListItem, ListItemRep>):DeleteUseCase<ListItem>
    @Binds
    abstract fun bindUpdateUseCase(useCase:UpdateUseCaseImplBase<ListItem, ListItemRep>):UpdateUseCase<ListItem>
    @Binds
    abstract fun bindReadUseCase(useCase:ReadUseCaseImplBase<ListItem, ListItemRep>):ReadUseCase<ListItem>
}