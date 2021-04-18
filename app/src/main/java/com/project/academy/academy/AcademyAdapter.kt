package com.project.academy.academy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.academy.R
import com.project.academy.data.CourseEntity
import com.project.academy.databinding.ItemsAcademyBinding
import com.project.academy.detail.DetailCourseActivity

class AcademyAdapter : RecyclerView.Adapter<AcademyAdapter.CourseViewHolder>() {

    //Array List from Dataclass Course Entity
    private var listCourse = ArrayList<CourseEntity>()

    fun setCourses(courses: List<CourseEntity>?) {
        if (null == courses) return
        this.listCourse.clear()
        this.listCourse.addAll(courses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        //view binding implementation
        val itemsAcademyBinding =
            ItemsAcademyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourse[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourse.size

    class CourseViewHolder(private val binding: ItemsAcademyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: CourseEntity) {
            with(binding) {
                tvItemTitle.text = course.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, course.deadline)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(course.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}