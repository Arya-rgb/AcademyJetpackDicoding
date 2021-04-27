package com.project.academy.academy.di

import android.content.Context
import com.project.academy.data.source.AcademyRepository
import com.project.academy.data.source.remote.RemoteDataSource
import com.project.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstances(remoteDataSource)
    }

}