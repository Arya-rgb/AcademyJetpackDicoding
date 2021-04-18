package com.project.academy.bookmark

import androidx.lifecycle.ViewModel
import com.project.academy.data.CourseEntity
import com.project.academy.utils.DataDummy

class BookmarkViewModel: ViewModel() {

    fun getBookmark(): List<CourseEntity> = DataDummy.generateDummyCourse()

}