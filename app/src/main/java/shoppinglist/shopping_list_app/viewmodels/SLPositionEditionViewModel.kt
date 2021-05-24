package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import shoppinglist.shopping_list_app.model.dataModels.BaseItem
import shoppinglist.shopping_list_app.model.dataModels.ListItem
import shoppinglist.shopping_list_app.model.repository.ListItemRep
import shoppinglist.shopping_list_app.model.usecases.base.BaseCompletableObserver
import shoppinglist.shopping_list_app.model.usecases.base.BaseSingleObserver
import shoppinglist.shopping_list_app.model.usecases.base.ReadUseCase
import shoppinglist.shopping_list_app.model.usecases.base.UpdateUseCase
import javax.inject.Inject

class SLPositionEditionViewModel @Inject constructor(private val readUseCase: ReadUseCase<ListItem>,
                                                     private val updateUseCase: UpdateUseCase<ListItem>): BaseViewModel() {

    var currentPosition = MutableLiveData<ListItem>()

    fun updatePosition(position: ListItem){
        updateUseCase.update(position, BaseCompletableObserver({}, {disposable -> compositeDisposable.add(disposable) }))
    }

    fun getPosition(id:Long){
        readUseCase.read(id, BaseSingleObserver({item -> currentPosition.postValue(item)},{disposable -> compositeDisposable.add(disposable)}))
    }

}