package com.example.spacex.data.repository

import com.apollographql.apollo.api.Response
import com.example.spacex.LaunchDetailsQuery
import com.example.spacex.LaunchesQuery

interface SpaceRepository {
    suspend fun queryLaunches(): Response<LaunchesQuery.Data>

    suspend fun queryLaunchDetails(id: String) : Response<LaunchDetailsQuery.Data>
}