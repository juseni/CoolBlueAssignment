package com.coolblue.assignment.repository

import com.coolblue.assignment.repositories.ObjectsForSaleRepository
import com.coolblue.assignment.utils.productsForSale
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

/**
 * @author Juan Sebastian Niño
 */
@RunWith(MockitoJUnitRunner::class)
class ObjectsForSaleRepositoryTest {

    @get:Rule
    val rule: MockitoRule = MockitoJUnit.rule()

    private lateinit var repository: ObjectsForSaleRepository

    @Before
    fun setup() {
        repository = ObjectsForSaleRepository()
    }

    @Test
    fun setDataTest() {
        repository.setData(productsForSale)
        Assert.assertEquals(repository.getProductsForSale(), productsForSale)
    }
}