package com.coolblue.data.utils

import com.coolblue.data.db.entity.ProductEntity
import com.coolblue.data.db.entity.ProductsEntity

/**
 * @author Juan Sebastian Niño
 */
val productsForSale = listOf(
    ProductEntity(
        101010,
        "https://image.coolblue.nl/300x750/products/984921",
        "Apple iPhone X 256GB Zilver",
        true,
        2,
        1950.0
    ),
    ProductEntity(
        22222,
        "https://image.coolblue.nl/300x750/products/406340",
        "Apple Usb-C to Digital AV Adapter",
        true,
        2,
        76.0
    )
)

val products = ProductsEntity(
    productsForSale,
    1,
    3,
    7,
    2
)