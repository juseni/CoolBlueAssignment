package com.coolblue.assignment.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coolblue.assignment.controllers.ObjectsForSaleController
import com.coolblue.assignment.repositories.ObjectsForSaleRepository
import com.coolblue.assignment.setup.RxImmediateSchedulerRule
import com.coolblue.assignment.utils.products
import com.coolblue.domain.core.Result
import com.coolblue.domain.exceptions.ConnectionException
import com.coolblue.domain.repositories.CoolBlueRepository
import com.nhaarman.mockitokotlin2.given
import io.reactivex.rxjava3.core.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

/**
 * @author Juan Sebastian Niño
 */
@RunWith(MockitoJUnitRunner::class)
class ObjectsForSaleViewModelTest {

    @get:Rule
    val testScheduleRule = RxImmediateSchedulerRule()
    @get:Rule
    val rule: MockitoRule = MockitoJUnit.rule()
    @get:Rule var rule2: TestRule = InstantTaskExecutorRule()


    private lateinit var controller: ObjectsForSaleController

    @Mock
    lateinit var useCase: CoolBlueRepository

    lateinit var repository: ObjectsForSaleRepository

    private lateinit var viewModel: ObjectsForSaleViewModel

    @Before
    fun setup() {
        repository = ObjectsForSaleRepository()

        controller = ObjectsForSaleController(useCase, repository)

        viewModel = ObjectsForSaleViewModel(controller)

        given(useCase.getObjectsForSale("iphone", 1)).willReturn(
            Single.just(Result.Success(products))
        )
    }

    @Test
    fun objectsForSaleTest() {
        viewModel.getObjectsForSale("iphone", page = 1)
        viewModel.objectsForSaleMutableLiveData.observeForever {
            Assert.assertEquals(products, it)
        }
    }

    @Test
    fun objectsForSaleErrorTest() {
        given(useCase.getObjectsForSale("iphone", 1)).willReturn(
            Single.just(Result.Error(ConnectionException()))
        )
        viewModel.getObjectsForSale("iphone", page = 1)
        viewModel.errorMutableLiveData.observeForever {
            Assert.assertTrue(it)
        }
    }
}