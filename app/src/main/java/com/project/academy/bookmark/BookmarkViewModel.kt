package com.project.academy.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.data.source.AcademyRepository
import com.project.academy.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    //fun getBookmark(): List<CourseEntity> = DataDummy.generateDummyCourse()
    fun getBookmark(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}