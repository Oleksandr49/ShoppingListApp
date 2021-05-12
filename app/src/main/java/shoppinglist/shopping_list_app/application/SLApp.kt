package shoppinglist.shopping_list_app.application

import android.app.Application
import shoppinglist.shopping_list_app.application.di.DaggerSLAppComponent
import shoppinglist.shopping_list_app.application.di.SLAppComponent

class SLApp : Application() {

    val appComponent: SLAppComponent by lazy { DaggerSLAppComponent.factory().create(applicationContext) }
}