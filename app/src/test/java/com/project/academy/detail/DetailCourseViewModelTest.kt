package com.project.academy.detail

import com.project.academy.data.CourseEntity
import com.project.academy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourse()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp() {
        viewModel= DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }


    @Test
    fun getCourse() {

        viewModel.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)


    }

    @Test
    fun getModule() {

        val moduleEntities = viewModel.getModule()
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size.toLong())

    }
}