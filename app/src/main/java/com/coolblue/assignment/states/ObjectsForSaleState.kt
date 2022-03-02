package com.coolblue.assignment.states

import com.coolblue.domain.model.ProductForSale

/**
 * @author Juan Sebastian Niño
 */
sealed class ObjectsForSaleState {

    data class SuccessObjectsForSale(val productsForSale: List<ProductForSale>) : ObjectsForSaleState()

    object OnErrorData : ObjectsForSaleState()
}