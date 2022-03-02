package com.coolblue.domain.model

data class ProductForSale(
    val productId: Int?,
    val productName: String?,
    val reviewInformation: ReviewData?,
    val specifications: Map<Int, String>?,
    val availabilityState: Int?,
    val salesPriceIncVat: Double?,
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