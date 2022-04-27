package com.example.spacex.di

import com.example.spacex.data.repository.SpaceRepository
import com.example.spacex.data.repository.SpaceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: SpaceRepositoryImpl): SpaceRepository

}