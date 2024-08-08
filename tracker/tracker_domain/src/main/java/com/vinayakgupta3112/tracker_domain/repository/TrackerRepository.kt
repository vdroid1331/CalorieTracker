package com.vinayakgupta3112.tracker_domain.repository

import com.vinayakgupta3112.tracker_domain.model.TrackableFood
import com.vinayakgupta3112.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)
    suspend fun deleteTrackedFoot(food: TrackedFood)
    suspend fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}