package com.project.academy.detail

import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.data.ModuleEntity
import com.project.academy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse() : CourseEntity {
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourse()
        for (courseEntity in coursesEntities) {
            if (courseId == courseEntity.courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModule(): List<ModuleEntity> = DataDummy.generateDummyModule(courseId)

}