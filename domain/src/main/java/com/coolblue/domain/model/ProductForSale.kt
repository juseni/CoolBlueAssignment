package com.coolblue.domain.model

import com.google.gson.annotations.SerializedName

/**
 * @author Juan Sebastian Niño
 */
data class ProductForSale(
    val productId: Int?,
    val productName: String?,
    val reviewInformation: ReviewData?,
    @SerializedName("USPs") val specifications: List<String>?,
    val availabilityState: Int?,
    @SerializedName("salesPriceIncVat") val price: Double?,
    val productImage: String?,
    val nextDayDelivery: Boolean?
)

data class ReviewData(
    val reviews: List<String>?,
    val reviewSummary: ReviewSummaryData?
)

data class ReviewSummaryData(
    val reviewAverage: Double?,
    val reviewCount: Int?
)