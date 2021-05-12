package shoppinglist.shopping_list_app.application.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component (modules = [ViewModelBuilderModule::class, LocalDatabaseModule::class, SubcomponentsModule::class])
interface SLAppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): SLAppComponent
    }

    fun slComponent(): SLComponent.Factory
    fun slPositionCreationComponent(): SLPositionCreationComponent.Factory
    fun slPositionEditionComponent(): SLPositionEditionComponent.Factory
    fun cartComponent(): CartComponent.Factory
}

@Module(subcomponents = [SLComponent::class,
    SLPositionCreationComponent::class,
    SLPositionEditionComponent::class,
    CartComponent::class])
object SubcomponentsModule