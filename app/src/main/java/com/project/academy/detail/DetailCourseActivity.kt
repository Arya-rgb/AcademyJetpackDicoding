package com.project.academy.detail

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.project.academy.R
import com.project.academy.databinding.ActivityDetailCourseBinding
import com.project.academy.databinding.ContentDetailCourseBinding

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

    }
}