package com.project.academy.academy

import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.data.source.AcademyRepository
import com.project.academy.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel()  {

    //fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourse()
    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()

}