package com.coolblue.assignment.controllers

import com.coolblue.assignment.di.scopes.ObjectsForSaleScope
import com.coolblue.assignment.repositories.ObjectsForSaleRepository
import com.coolblue.assignment.states.ObjectsForSaleState
import com.coolblue.assignment.utils.applySchedulersOnIo
import com.coolblue.domain.core.Result
import com.coolblue.domain.repositories.CoolBlueRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@ObjectsForSaleScope
class ObjectsForSaleController @Inject constructor(
    private val useCase: CoolBlueRepository,
    private val repository: ObjectsForSaleRepository
) {
    private val disposables = CompositeDisposable()

    private val publishSubject = PublishSubject.create<ObjectsForSaleState>()
    fun observeObjectsForSale(): Observable<ObjectsForSaleState> = publishSubject.hide()

    fun requestObjectsForSale(query: String, page: Int) {
        useCase.getObjectsForSale(query, page)
            .applySchedulersOnIo()
            .subscribe({
                when (it) {
                    is Result.Success -> {
                        repository.setData(it.data.products)
                        publishSubject.onNext(ObjectsForSaleState.SuccessObjectsForSale(it.data.products))
                    }
                    is Result.Error ->
                        publishSubject.onNext(ObjectsForSaleState.OnErrorData)
                }
            }, {
                publishSubject.onNext(ObjectsForSaleState.OnErrorData)
            }).addTo(disposables)
    }
}