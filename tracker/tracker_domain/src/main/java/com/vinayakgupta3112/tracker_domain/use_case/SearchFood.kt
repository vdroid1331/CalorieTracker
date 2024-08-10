package com.vinayakgupta3112.tracker_domain.use_case

import com.vinayakgupta3112.tracker_domain.model.TrackableFood
import com.vinayakgupta3112.tracker_domain.repository.TrackerRepository

class SearchFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 100
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}