package com.project.academy.detail

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

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModule(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

}