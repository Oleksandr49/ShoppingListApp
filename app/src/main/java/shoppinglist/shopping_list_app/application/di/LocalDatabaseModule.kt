package shoppinglist.shopping_list_app.application.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import shoppinglist.shopping_list_app.model.repository.BaseDataBase
import shoppinglist.shopping_list_app.model.repository.CartPositionDAO
import shoppinglist.shopping_list_app.model.repository.SLPositionDAO
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
    fun SLPositionDAO(dataBase: BaseDataBase) = dataBase.SLPositionDAO()

    @Singleton
    @Provides
    fun CartPositionDAO(dataBase: BaseDataBase) = dataBase.CartPositionDAO()
}