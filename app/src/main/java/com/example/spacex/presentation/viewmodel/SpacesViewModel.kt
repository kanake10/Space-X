package com.example.spacex.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.annotation.ExperimentalCoilApi
import com.apollographql.apollo.api.Response
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.apollographql.apollo.exception.ApolloException
import com.example.spacex.LaunchDetailsQuery
import com.example.spacex.LaunchesQuery
import com.example.spacex.core.Resource
import com.example.spacex.data.repository.SpaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoilApi
@HiltViewModel
class SpacesViewModel @Inject constructor(
    private val repository: SpaceRepository
)  : ViewModel() {

    private val _launches by lazy {MutableLiveData<Resource<Response<LaunchesQuery.Data>>>()}
    val launches: LiveData<Resource<Response<LaunchesQuery.Data>>>
        get() = _launches

    private val _launchDetails by lazy { MutableLiveData<Resource<Response<LaunchDetailsQuery.Launch>>>() }
    val launchDetails: MutableLiveData<Resource<Response<LaunchDetailsQuery.Launch>>>
        get() = _launchDetails

    fun queryLaunches() = viewModelScope.launch{
        _launches.postValue(Resource.Loading())
        try {
            val response = repository.queryLaunches()
            _launches.postValue(Resource.Success(response))
        } catch (e: ApolloException) {
            _launches.postValue(Resource.Error("Error fetching data"))
        }
    }

    fun queryLaunchDetails(id: String) = viewModelScope.launch {
        _launchDetails.postValue(Resource.Loading())
        try {
            val response = repository.queryLaunchDetails(id)
            _launchDetails.postValue(Resource.Success(response))
        } catch (e: ApolloException) {
            _launchDetails.postValue(Resource.Error("Error fetching data"))
        }
    }


}