package shoppinglist.shopping_list_app.application.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import shoppinglist.shopping_list_app.model.repository.base.BaseDataBase
import javax.inject.Singleton

@Module
object LocalDatabaseModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(context: Context): BaseDataBase {
        return Room.databaseBuilder(context, BaseDataBase::class.java, "LocalDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun listItemDao(dataBase: BaseDataBase) = dataBase.listItemDao()

    @Singleton
    @Provides
    fun cartItemDao(dataBase: BaseDataBase) = dataBase.cartItemDao()

    @Singleton
    @Provides
    fun productDao(dataBase: BaseDataBase) = dataBase.productDao()

    @Singleton
    @Provides
    fun cartDao(dataBase: BaseDataBase) = dataBase.cartDao()
}
