package com.project.academy.bookmark

import com.project.academy.data.CourseEntity

interface BookmarkFragmentCallback {

    fun onShareClick(course: CourseEntity)

}
