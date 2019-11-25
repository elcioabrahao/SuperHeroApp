package com.trantordev.superheroapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trantordev.superheroapp.data.model.Hero
import com.trantordev.superheroapp.databinding.HeroItemBinding

class MainAdapter: ListAdapter<Hero, RecyclerView.ViewHolder>(HeroDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hero = getItem(position)
        (holder as HeroViewHolder).bind(hero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HeroViewHolder(
            HeroItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    class HeroViewHolder(
        private val binding: HeroItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                // On click não implementado propositalmente
            }
        }

        fun bind(item: Hero) {
            binding.apply {
                superhero = item
                executePendingBindings()
            }
        }
    }
}

private class HeroDiffCallback : DiffUtil.ItemCallback<Hero>() {

    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.equals(newItem)
    }
}