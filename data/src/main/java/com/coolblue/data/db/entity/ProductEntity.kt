package com.coolblue.data.db.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Juan Sebastian Niño
 */
data class ProductEntity(
    @SerializedName("productId") val productId: Int,
    @SerializedName("productImage") val productImage: String? = null,
    @SerializedName("productName") val productName: String? = null,
    @SerializedName("nextDayDelivery") val nextDayDelivery: Boolean? = null,
    @SerializedName("availabilityState") val availabilityState: Int? = null,
    @SerializedName("salesPriceIncVat") val salesPriceIncVat: Double? = null

   /* @SerializedName("reviewInformation")  val reviewInformation: ReviewData? = null,
    @SerializedName("USPs") val specifications: Map<Int, String>? = null,
    @SerializedName("availabilityState") val availabilityState: Int? = null,
    @SerializedName("salesPriceIncVat") val price: Double? = null,
    @SerializedName("productImage") val productImage: String? = null,
    */
)

data class ReviewData(
    @SerializedName("reviews") val reviews: List<String>? = emptyList(),
    @SerializedName("reviewSummary") val reviewSummary: ReviewSummaryData? = null
)

data class ReviewSummaryData(
    @SerializedName("reviewAverage") val reviewAverage: Double? = null,
    @SerializedName("reviewCount") val reviewCount: Int? = null
)