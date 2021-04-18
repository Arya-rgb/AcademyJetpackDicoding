package com.project.academy.academy

import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.utils.DataDummy

class AcademyViewModel : ViewModel()  {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourse()

}