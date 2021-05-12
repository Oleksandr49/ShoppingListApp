package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {

    val compositeDisposable = CompositeDisposable()

    fun dispose(){
        compositeDisposable.dispose()
    }
}