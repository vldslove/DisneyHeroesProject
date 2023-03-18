package com.example.disneyHeroes.characterlist

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyHeroes.model.CharacterInfo
import com.example.disneyHeroes.databinding.HeroItemBinding

class HeroListViewHolder(
    private val binding: HeroItemBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun showCharacters(char: CharacterInfo) {
        binding.characterName.text = char.name
        Glide.with(binding.root.context).load(char.imageUrl).into(binding.characterImage)

    }
}
