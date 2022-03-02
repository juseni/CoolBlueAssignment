package com.coolblue.assignment.repositories

import com.coolblue.assignment.di.scopes.ObjectsForSaleScope
import com.coolblue.domain.model.ProductForSale
import javax.inject.Inject

/**
 * @author Juan Sebastian Niño
 */
@ObjectsForSaleScope
class ObjectsForSaleRepository @Inject constructor() {
    companion object {
        private var productsForSale: List<ProductForSale> = emptyList()
    }

    fun setData(products: List<ProductForSale>) {
        clearData()
        productsForSale = products
    }

    private fun clearData() {
        productsForSale = emptyList()
    }

    fun getProductsForSale() = productsForSale

    fun getProductForSaleByProductId(productId: Int) = productsForSale.firstOrNull { it.productId == productId }
}