package com.coolblue.data.db.entity

import com.google.gson.annotations.SerializedName


/**
 * @author Juan Sebastian Niño
 */

data class ProductsEntity(
    @SerializedName("products") val products: List<ProductEntity>,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("pageSizeval") val pageSizeval : Int,
    @SerializedName("totalResultsval") val totalResultsval : Int,
    @SerializedName("pageCount") val pageCount: Int
)