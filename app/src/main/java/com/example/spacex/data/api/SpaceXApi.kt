package com.example.spacex.data.api

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import com.example.spacex.core.Constants.SERVER_URL
import okhttp3.OkHttpClient

class SpaceXApi {

    fun getApolloClient(): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl(SERVER_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

}