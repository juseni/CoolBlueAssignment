package com.coolblue.assignment.utils

import com.coolblue.domain.model.ProductForSale
import com.coolblue.domain.model.Products

/**
 * @author Juan Sebastian Niño
 */
val productsForSale = listOf(
    ProductForSale(
        101010,
        productImage = "https://image.coolblue.nl/300x750/products/984921",
        productName = "Apple iPhone X 256GB Zilver",
        nextDayDelivery = true,
        availabilityState = 2,
        price = 1950.0,
        reviewInformation = null,
        specifications = null
    ),
    ProductForSale(
        22222,
        productImage = "https://image.coolblue.nl/300x750/products/406340",
        productName = "Apple Usb-C to Digital AV Adapter",
        nextDayDelivery = true,
        availabilityState = 2,
        price = 76.0,
        reviewInformation = null,
        specifications = null
    )
)

val products = Products(
    productsForSale
)