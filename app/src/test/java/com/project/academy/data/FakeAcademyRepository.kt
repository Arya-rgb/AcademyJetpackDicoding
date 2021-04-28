package com.project.academy.data


import com.project.academy.data.source.AcademyDataSource
import com.project.academy.data.source.remote.RemoteDataSource

class FakeAcademyRepository (private val remoteDataSource: RemoteDataSource) :
    AcademyDataSource {

    override fun getAllCourses(): ArrayList<CourseEntity> {
        val courseResponse = remoteDataSource.getAllCourses()
        val courseList = ArrayList<CourseEntity>()
        for (response in courseResponse) {
            val course = CourseEntity(
                response.id,
                response.title,
                response.description,
                response.date,
                false,
                response.imagePath
            )

            courseList.add(course)
        }
        return courseList
    }

    override fun getBookmarkedCourses(): ArrayList<CourseEntity> {
        val courseResponse = remoteDataSource.getAllCourses()
        val courseList = ArrayList<CourseEntity>()
        for (response in courseResponse) {
            val course = CourseEntity(
                response.id,
                response.title,
                response.description,
                response.date,
                false,
                response.imagePath
            )
            courseList.add(course)
        }
        return courseList
    }

    override fun getCourseWithModules(courseId: String): CourseEntity {
        val courseResponse = remoteDataSource.getAllCourses()
        lateinit var course: CourseEntity
        for (response in courseResponse) {
            if (response.id == courseId) {
                course = CourseEntity(
                    response.id,
                    response.title,
                    response.description,
                    response.date,
                    false,
                    response.imagePath
                )
            }
        }
        return course
    }

    override fun getAllModulesByCourse(courseId: String): ArrayList<ModuleEntity> {
        val moduleResponse = remoteDataSource.getModules(courseId)
        val moduleList = ArrayList<ModuleEntity>()
        for (response in moduleResponse) {
            val course = ModuleEntity(
                response.moduleId,
                response.courseId,
                response.title,
                response.position,
                false
            )

            moduleList.add(course)
        }
        return moduleList
    }

    override fun getContent(courseId: String, moduleId: String): ModuleEntity {
        val moduleResponse = remoteDataSource.getModules(courseId)
        lateinit var module: ModuleEntity
        for (response in moduleResponse) {
            if (response.moduleId == moduleId) {
                module = ModuleEntity(
                    response.moduleId,
                    response.courseId,
                    response.title,
                    response.position,
                    false
                )
                module.contentEntity = ContentEntity(remoteDataSource.getContent(moduleId).content)
            }
        }
        return module
    }

}