package com.vinayakgupta3112.tracker_data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.vinayakgupta3112.tracker_data.local.TrackerDao
import com.vinayakgupta3112.tracker_data.mapper.toTrackableFood
import com.vinayakgupta3112.tracker_data.mapper.toTrackedFood
import com.vinayakgupta3112.tracker_data.mapper.toTrackedFoodEntity
import com.vinayakgupta3112.tracker_data.remote.OpenFoodApi
import com.vinayakgupta3112.tracker_domain.model.TrackableFood
import com.vinayakgupta3112.tracker_domain.model.TrackedFood
import com.vinayakgupta3112.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val api: OpenFoodApi
): TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {

        return try {
            val searchDto = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDto.products.mapNotNull {
                    it.toTrackableFood()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun deleteTrackedFoot(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }

}