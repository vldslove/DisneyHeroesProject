package com.example.disneyHeroes.onecharacter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.disneyHeroes.model.CharacterInfo
import com.example.disneyHeroes.R
import com.example.disneyHeroes.characterlist.ListFragment
import com.example.disneyHeroes.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterDescription: Fragment() {
    private val viewModel: CharacterDescriptionViewModel by viewModels()
    private lateinit var binding: FragmentDescriptionBinding
    private lateinit var favouriteCharacter: CharacterInfo
    private val args: CharacterDescriptionArgs by navArgs()
    private var favouriteList: ArrayList<CharacterInfo>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        viewModel.listChar.observe(viewLifecycleOwner) { list ->
            for (i in 0 until list.size) {
                if (list[i]._id?.toString().equals(args.idChar)) {
                    setDescriptionOfHero(list, i)
                    favouriteCharacter = list[i]
                }
            }
        }
        viewModel.getCharacter()

        viewModel.listFavChar.observe(viewLifecycleOwner) {
            favouriteList = it
        }
        viewModel.getFavouriteCharacter()




        binding.favButton.setOnClickListener {
            viewModel.putFavouriteCharacter(favouriteCharacter)
            binding.favButton.visibility = View.INVISIBLE
            binding.deleteButton.visibility = View.VISIBLE
        }


        viewModel.charAdded =
            {
                binding.bannerView.visibility = View.VISIBLE
                binding.bannerView.setTitle("Character successfully added")
                binding.bannerView.setClick {
                    viewModel.getCharacter()
                }
            }

        binding.deleteButton.setOnClickListener {

            viewModel.deleteFavouriteCharacter(favouriteCharacter)
            binding.favButton.visibility = View.VISIBLE
            binding.deleteButton.visibility = View.INVISIBLE
        }
        viewModel.charDeleted =
            {
                binding.bannerView.visibility = View.VISIBLE
                binding.bannerView.setTitle("Character successfully deleted")
                binding.bannerView.setClick {
                    viewModel.getCharacter()
                }
            }


    }



    @SuppressLint("SetTextI18n")
    fun setDescriptionOfHero(list: ArrayList<CharacterInfo>, position: Int) {
        binding.descriptionCharacterName.text = "Hero name: " + list[position].name
        Glide.with(binding.root.context).load(list[position].imageUrl)
            .into(binding.descriptionCharacterImage)
        binding.descriptionCharacterAllies.text = "Allies: " + list[position].allies.toString()
        binding.descriptionCharacterEnemies.text = "Enemies: " + list[position].enemies.toString()
        binding.descriptionCharacterFilms.text = "Films: " + list[position].films
        binding.descriptionCharacterShortFilms.text =
            "Short Films: " + list[position].shortFilms.toString()
        binding.descriptionCharacterTvShows.text = "TV Shows: " + list[position].tvShows.toString()
        binding.descriptionCharacterVideoGames.text =
            "Video Games: " + list[position].videoGames.toString()
        binding.descriptionCharacterURL.text = "URL: " + list[position].url
        for (i in 0 until favouriteList?.size!!) {
            if (favouriteList!![i]._id.toString().equals(args.idChar)) {
                binding.favButton.visibility = View.INVISIBLE
                binding.deleteButton.visibility = View.VISIBLE
            }
        }


    }
}