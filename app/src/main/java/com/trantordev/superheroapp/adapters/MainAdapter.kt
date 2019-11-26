package com.trantordev.superheroapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trantordev.superheroapp.R
import com.trantordev.superheroapp.data.model.Hero
import com.trantordev.superheroapp.databinding.HeroItemBinding

class MainAdapter(): ListAdapter<Hero, RecyclerView.ViewHolder>(HeroDiffCallback()) {

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
                // do nothing
            }
        }

        fun bind(item: Hero) {
            binding.apply {
                superhero = item
                Glide.with(binding.root)
                    .load("https://bitbucket.org/dttden/mobile-coding-challenge/raw/259972edefb1eed313b3a8f1a0cc1d822aa5914f/${item.picture.replace(".jpeg",".jpg")}")
                    .centerCrop()
                    .error(R.drawable.error)
                    .fallback(R.drawable.noimage)
                    .into(heroImage)
                
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