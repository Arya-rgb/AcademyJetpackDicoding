package com.project.academy.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.academy.data.ModuleEntity
import com.project.academy.databinding.ItemsModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {

    private val listModule = ArrayList<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>?) {
        if (null == modules) return
            this.listModule.clear()
            this.listModule.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailCourseAdapter.ModuleViewHolder {
        val itemModuleListBinding = ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: DetailCourseAdapter.ModuleViewHolder, position: Int) {
        val module = listModule[position]
        holder.bind(module)
    }

    override fun getItemCount(): Int = listModule.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }

}