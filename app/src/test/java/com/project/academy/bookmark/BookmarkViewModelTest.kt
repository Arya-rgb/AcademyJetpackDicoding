package com.project.academy.bookmark

import com.project.academy.data.CourseEntity
import com.project.academy.data.source.AcademyRepository
import com.project.academy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmark() {
        Mockito.`when`<ArrayList<CourseEntity>>(academyRepository.getBookmarkedCourses()).thenReturn(
            DataDummy.generateDummyCourses() as ArrayList<CourseEntity>
        )
        val courseEntities = viewModel.getBookmark()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)

    }
}