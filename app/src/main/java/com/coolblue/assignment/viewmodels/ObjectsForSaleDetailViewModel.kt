package com.coolblue.assignment.viewmodels

import androidx.lifecycle.ViewModel
import com.coolblue.domain.repositories.CoolBlueRepository
import javax.inject.Inject

class ObjectsForSaleDetailViewModel @Inject constructor(
    private val useCase: CoolBlueRepository
): ViewModel() {
}