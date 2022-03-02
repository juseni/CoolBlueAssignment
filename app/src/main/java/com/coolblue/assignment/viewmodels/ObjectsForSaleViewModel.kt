package com.coolblue.assignment.viewmodels


import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.coolblue.assignment.controllers.ObjectsForSaleController
import com.coolblue.assignment.states.ObjectsForSaleState
import com.coolblue.domain.model.ProductForSale
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ObjectsForSaleViewModel @Inject constructor(
    private val controller: ObjectsForSaleController
): ViewModel(), LifecycleObserver {

    private var compositeDisposable = CompositeDisposable()
    val objectsForSaleMutableLiveData = MutableLiveData<List<ProductForSale>>()
    val errorMutableLiveData = MutableLiveData<Boolean>()

    fun setupObserver() {
        compositeDisposable.add(
            controller.observeObjectsForSale()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        when(it) {
                            is ObjectsForSaleState.SuccessObjectsForSale ->
                                objectsForSaleMutableLiveData.postValue(it.productsForSale)
                            is ObjectsForSaleState.OnErrorData ->
                                errorMutableLiveData.postValue(true)
                        }
                    }, {
                        errorMutableLiveData.postValue(true)
                    }
                )
        )
    }

    fun getObjectsForSale(query: String, page: Int) {
        controller.requestObjectsForSale(query, page)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        compositeDisposable.clear()
    }
}