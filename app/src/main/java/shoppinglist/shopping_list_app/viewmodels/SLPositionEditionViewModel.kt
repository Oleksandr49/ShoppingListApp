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
import javax.inject.Inject

class SLPositionEditionViewModel @Inject constructor(private val repository: ListItemRep): ViewModel() {

    var currentPosition = MutableLiveData<BaseItem>()

    fun updatePosition(position: ListItem){
        repository.update(position).
        subscribeOn(Schedulers.io()).
        observeOn(AndroidSchedulers.mainThread()).
        subscribe(object:CompletableObserver{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    fun getPosition(id:Long){
        repository.get(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<BaseItem>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(t: BaseItem) {
                    currentPosition.postValue(t)
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}