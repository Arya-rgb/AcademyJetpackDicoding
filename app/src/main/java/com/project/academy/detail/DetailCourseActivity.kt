package com.project.academy.detail

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.project.academy.R
import com.project.academy.data.CourseEntity
import com.project.academy.databinding.ActivityDetailCourseBinding
import com.project.academy.databinding.ContentDetailCourseBinding
import com.project.academy.reader.CourseReaderActivity
import com.project.academy.utils.DataDummy

class DetailCourseActivity : AppCompatActivity() {

    /*
   Every class can implement a companion object,
   which is an object that is common to all instances of that class.
   can also be used for passing data from another activity
     */
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    //viewbinding implementation
    private lateinit var detailContentBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view binding implementation for main layout
        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        //view binding implementation for detail content
        detailContentBinding = activityDetailCourseBinding.detailContent

        //set content view with binding's root
        setContentView(activityDetailCourseBinding.root)

        //set support action bar for this layout
        setSupportActionBar(activityDetailCourseBinding.toolbar)
        //will make the icon clickable and add the < at the left of the icon.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailCourseAdapter()

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailCourseViewModel::class.java]


        val extras = intent.extras
        if (null != extras) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (null != courseId) {
                viewModel.setSelectedCourse(courseId)
                val modules = viewModel.getModule()
                adapter.setModules(modules)
                populateCourse(viewModel.getCourse() as CourseEntity)
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.textDescription.text = courseEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
            .load(courseEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}