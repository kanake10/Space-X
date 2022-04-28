package com.example.spacex.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.spacex.LaunchesQuery
import com.example.spacex.R
import com.example.spacex.databinding.ItemLaunchesBinding

class SpaceAdapter :
    ListAdapter<LaunchesQuery.Launch, CharacterViewHolder>(CharacterDiffUtil()) {

    var onItemClicked: ((LaunchesQuery.Launch) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: ItemLaunchesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_launches,
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.binding.launches = getItem(position)

        val launches = getItem(position)
        holder.binding.root.setOnClickListener {
            onItemClicked?.invoke(launches)
        }
    }

}

class CharacterViewHolder(val binding: ItemLaunchesBinding) : RecyclerView.ViewHolder(binding.root)

class CharacterDiffUtil : DiffUtil.ItemCallback<LaunchesQuery.Launch>() {

    override fun areItemsTheSame(
        oldItem: LaunchesQuery.Launch,
        newItem: LaunchesQuery.Launch
    ): Boolean {
        return oldItem.mission_name == newItem.mission_name
    }

    override fun areContentsTheSame(
        oldItem: LaunchesQuery.Launch,
        newItem: LaunchesQuery.Launch
    ): Boolean {
        return oldItem == newItem
    }

}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    imageView.load(url) { crossfade(true) }
}