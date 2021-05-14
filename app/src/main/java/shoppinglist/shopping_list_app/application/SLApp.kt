package shoppinglist.shopping_list_app.application

import android.app.Application
import shoppinglist.shopping_list_app.application.di.components.DaggerSLAppComponent
import shoppinglist.shopping_list_app.application.di.components.SLAppComponent

class SLApp : Application() {

    val appComponent: SLAppComponent by lazy { DaggerSLAppComponent.factory().create(applicationContext) }
}