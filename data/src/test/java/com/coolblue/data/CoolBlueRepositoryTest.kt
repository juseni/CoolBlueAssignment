package com.coolblue.data

import com.coolblue.data.platform.NetworkHandler
import com.coolblue.data.repositories.CoolBlueRepositoryImpl
import com.coolblue.data.setup.RxImmediateSchedulerRule
import com.coolblue.data.source.CoolBlueApi
import com.coolblue.data.utils.products
import com.coolblue.domain.core.Result
import com.coolblue.domain.exceptions.ConnectionException
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.given
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import retrofit2.Response

/**
 * @author Juan Sebastian Niño
 */
@RunWith(MockitoJUnitRunner::class)
class CoolBlueRepositoryTest {

    @get:Rule
    val testScheduleRule = RxImmediateSchedulerRule()
    @get:Rule
    val rule: MockitoRule = MockitoJUnit.rule()

    private var gson = Gson()

    @Mock
    lateinit var apiService: CoolBlueApi

    @Mock
    lateinit var networkChecker: NetworkHandler

    private lateinit var repositoryImpl: CoolBlueRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        given(networkChecker.isConnected()).willReturn(true)
        given(apiService.getObjectsForSaleByQuery("iphone", 1)).willReturn(
            Single.just(Response.success(products))
        )
        repositoryImpl = CoolBlueRepositoryImpl(
            gson,
            apiService,
            networkChecker
        )
    }

    @Test
    fun getObjectsForSaleTest() {
        val result = repositoryImpl.getObjectsForSale("iphone", 1)
        result.map {
            assertEquals(Result.Success(products), it)
        }
    }

    @Test
    fun getObjectsForSaleTestFailed() {
        given(networkChecker.isConnected()).willReturn(false)
        val result = repositoryImpl.getObjectsForSale("iphone", 1)
        result.map {
            assertEquals(Result.Error(ConnectionException()), it)
        }
    }
}