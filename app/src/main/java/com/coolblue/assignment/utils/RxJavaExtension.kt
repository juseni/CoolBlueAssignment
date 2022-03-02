package com.coolblue.assignment.utils

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * @author Juan Sebastian Niño
 */
fun <T> Single<T>.applySchedulersOnIo(): Single<T> {
    return subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
}