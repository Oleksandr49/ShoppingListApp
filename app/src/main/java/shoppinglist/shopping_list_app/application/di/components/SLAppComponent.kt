package shoppinglist.shopping_list_app.application.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import shoppinglist.shopping_list_app.application.di.modules.*
import javax.inject.Singleton

@Singleton
@Component (modules = [ViewModelBuilderModule::class,
    LocalDatabaseModule::class,
    SubcomponentsModule::class,
    UseCasesModule::class])
interface SLAppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): SLAppComponent
    }

    fun slComponent(): SLComponent.Factory
    fun slPositionCreationComponent(): SLPositionCreationComponent.Factory
    fun slPositionEditionComponent(): SLPositionEditionComponent.Factory
    fun cartComponent(): CartComponent.Factory
    fun productsComponent(): ProductsComponent.Factory
    fun historyComponent(): HistoryComponent.Factory
    fun carteDetailsComponent(): CartDetailsComponent.Factory
}

@Module(subcomponents = [SLComponent::class,
    SLPositionCreationComponent::class,
    SLPositionEditionComponent::class,
    CartComponent::class,
    ProductsComponent::class,
    HistoryComponent::class,
    CartDetailsComponent::class])
object SubcomponentsModule

@Module(includes = [ListItemUseCasesModule::class,
    BaseProductUseCasesModule::class,
    CartItemUseCasesModule::class,
    CartUseCasesModule::class])
object UseCasesModule