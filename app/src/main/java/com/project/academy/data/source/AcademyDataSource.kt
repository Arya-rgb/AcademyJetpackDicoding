package com.project.academy.data.source

import com.project.academy.data.CourseEntity
import com.project.academy.data.ModuleEntity

interface AcademyDataSource {

    fun getAllCourses(): List<CourseEntity>
    fun getBookmarkedCourses(): List<CourseEntity>
    fun getCourseWithModules(courseId: String): CourseEntity
    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>
    fun getContent(courseId: String, moduleId: String): ModuleEntity

}