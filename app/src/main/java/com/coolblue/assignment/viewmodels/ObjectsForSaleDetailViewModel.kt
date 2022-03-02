package com.coolblue.assignment.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coolblue.assignment.controllers.ObjectsForSaleController
import com.coolblue.domain.model.ProductForSale
import javax.inject.Inject

/**
 * @author Juan Sebastian Niño
 */
class ObjectsForSaleDetailViewModel @Inject constructor(
    private val controller: ObjectsForSaleController
): ViewModel(), LifecycleObserver {

    var productForSaleMutableLiveData = MutableLiveData<ProductForSale>()

    fun getProductForSale(productId: Int) {
        if (productId > 0) {
            controller.getProductForSaleByProductId(productId)?.let {
                productForSaleMutableLiveData.postValue(it)
            }
        }
    }
}