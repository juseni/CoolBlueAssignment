package com.coolblue.assignment.states

import com.coolblue.domain.model.ProductForSale

sealed class ObjectsForSaleState {

    data class SuccessObjectsForSale(val productsForSale: List<ProductForSale>) : ObjectsForSaleState()

    object OnErrorData : ObjectsForSaleState()
}