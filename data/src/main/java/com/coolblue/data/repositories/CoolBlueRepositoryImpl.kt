package com.coolblue.data.repositories

import com.coolblue.data.platform.NetworkHandler
import com.coolblue.data.source.CoolBlueApi
import com.coolblue.data.utilis.mapToObject
import com.coolblue.domain.core.Result
import com.coolblue.domain.exceptions.ConnectionException
import com.coolblue.domain.model.Products
import com.coolblue.domain.repositories.CoolBlueRepository
import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import java.lang.Exception
import javax.inject.Inject

class CoolBlueRepositoryImpl(
    val gson: Gson,
    val api: CoolBlueApi,
    val networkHandler: NetworkHandler
) : CoolBlueRepository {

    override fun getObjectsForSale(query: String, page: Int): Single<Result<Products>> {
        return if (networkHandler.isConnected()) {
             api.getObjectsForSaleByQuery(query, page).flatMap { response ->
                //api.getPrueba().flatMap { response ->
                if (response.isSuccessful) {
                    Single.just(Result.Success(gson.mapToObject(response.body()!!)))
                } else {
                    Single.just(Result.Error(Exception("Something wrong")))
                }
            }
        } else {
            Single.just(Result.Error(ConnectionException()))
        }
    }
}