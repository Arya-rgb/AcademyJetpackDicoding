package com.project.academy.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.academy.R
import com.project.academy.academy.viewmodel.ViewModelFactory
import com.project.academy.data.CourseEntity
import com.project.academy.databinding.FragmentBookmarkBinding
import com.project.academy.utils.DataDummy


class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //inflate the layout for this fragment
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (null != activity) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]

            val bookmarkAdapter = BookmarkAdapter(this)

            fragmentBookmarkBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmark().observe(viewLifecycleOwner, { courses ->
                fragmentBookmarkBinding.progressBar.visibility = View.GONE
                bookmarkAdapter.setCourses(courses)
                bookmarkAdapter.notifyDataSetChanged()
            })

            with(fragmentBookmarkBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkAdapter
            }

        }

    }

    override fun onShareClick(course: CourseEntity) {
        if (null != activity) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text,course.title))
                .startChooser()
        }
    }
}