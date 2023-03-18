package com.example.disneyHeroes.characterlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.disneyHeroes.model.CharacterInfo
import com.example.disneyHeroes.databinding.HeroItemBinding

class HeroListAdapter(private val onClick: (id: String) -> Unit) : RecyclerView.Adapter<HeroListViewHolder>() {

    private var list = arrayListOf<CharacterInfo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        return HeroListViewHolder(
            HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) {
        list[position].let { char ->
            holder.showCharacters(char)
            holder.itemView.setOnClickListener{
                onClick(char._id.toString())
            }
        }

    }

    override fun getItemCount() = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<CharacterInfo>){
        this.list = list
        notifyDataSetChanged()
    }


}