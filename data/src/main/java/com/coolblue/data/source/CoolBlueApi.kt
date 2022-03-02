package com.coolblue.data.source

import com.coolblue.data.db.entity.ProductsEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoolBlueApi {

    companion object {
        private const val SEARCH = "search"
        private const val QUERY = "query"
        private const val PAGE = "page"
    }

    @Headers("Content-Type: application/json")
    @GET(SEARCH)
    fun getObjectsForSaleByQuery(
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int
    ): Single<Response<ProductsEntity>>
}