package com.project.academy.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.academy.data.ModuleEntity
import com.project.academy.databinding.ItemsModuleListBinding
import com.project.academy.databinding.ItemsModuleListCustomBinding
import com.project.academy.detail.DetailCourseAdapter

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener): RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {

    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (null == modules) return
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleListAdapter.ModuleViewHolder {
        val binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleListAdapter.ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.bindingAdapterPosition, listModules[holder.bindingAdapterPosition].moduleId)
        }
    }

    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListCustomBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }

    internal interface MyAdapterClickListener {
        fun onItemClicked(position: Int, moduleId: String)
    }

}