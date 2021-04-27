package com.project.academy.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.project.academy.R
import com.project.academy.academy.viewmodel.ViewModelFactory
import com.project.academy.data.ContentEntity
import com.project.academy.data.ModuleEntity
import com.project.academy.databinding.FragmentModuleContentBinding
import com.project.academy.reader.CourseReaderViewModel

class ModuleContentFragment : Fragment() {

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentFragment: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentModuleContentFragment = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (null != activity) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

    private fun populateWebView(module: ModuleEntity) {
        fragmentModuleContentFragment.webView.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

}