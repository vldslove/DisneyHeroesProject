package com.example.disneyHeroes

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.disneyHeroes.databinding.ViewBannerBinding

class BannerView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private lateinit var binding: ViewBannerBinding

    init {
        binding = ViewBannerBinding.inflate(LayoutInflater.from(context), this, true)

    }

    fun setTitle(title: String) {
        binding.bannerTitle.text = title
    }

    fun setClick(onClick: () -> Unit) {
        binding.Ok.setOnClickListener{
            this.visibility = View.GONE
            onClick()
        }
    }
}