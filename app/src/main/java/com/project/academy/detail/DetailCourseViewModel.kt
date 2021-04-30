package com.project.academy.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.data.ModuleEntity
import com.project.academy.data.source.AcademyRepository
import com.project.academy.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)

    fun getModule(): LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseId)

}