package shoppinglist.shopping_list_app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import shoppinglist.shopping_list_app.model.dataModels.SLPosition
import shoppinglist.shopping_list_app.model.repository.SLPositionRepository
import javax.inject.Inject

class SLPositionEditionViewModel @Inject constructor(private val repository: SLPositionRepository): ViewModel() {

    var currentPosition = MutableLiveData<SLPosition>()

    fun updatePosition(position: SLPosition){
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
            .subscribe(object : SingleObserver<SLPosition>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onSuccess(t: SLPosition) {
                    currentPosition.postValue(t)
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}