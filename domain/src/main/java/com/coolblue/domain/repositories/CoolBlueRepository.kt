package com.coolblue.domain.repositories

import com.coolblue.domain.core.Result
import com.coolblue.domain.model.Products
import io.reactivex.rxjava3.core.Single

/**
 * @author Juan Sebastian Niño
 */
interface CoolBlueRepository {

    fun getObjectsForSale(query: String, page: Int) : Single<Result<Products>>
}