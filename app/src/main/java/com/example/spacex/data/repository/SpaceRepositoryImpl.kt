package com.example.spacex.data.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.spacex.LaunchDetailsQuery
import com.example.spacex.LaunchesQuery
import com.example.spacex.data.api.SpaceXApi
import javax.inject.Inject

class SpaceRepositoryImpl @Inject constructor(
    private val webService: SpaceXApi
) : SpaceRepository{
    override suspend fun queryLaunches(): Response<LaunchesQuery.Data> {
        return webService.getApolloClient().query(LaunchesQuery()).await()
    }

    override suspend fun queryLaunchDetails(id: String): Response<LaunchDetailsQuery.Data> {
        return webService.getApolloClient().query(LaunchDetailsQuery(id)).await()

    }
}