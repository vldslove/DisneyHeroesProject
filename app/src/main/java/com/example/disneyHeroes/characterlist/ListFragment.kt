package com.example.disneyHeroes.characterlist

import com.example.disneyHeroes.R
import com.example.disneyHeroes.onecharacter.CharacterDescription
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneyHeroes.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.allHeroes.setOnClickListener {
            viewModel.listChar.observe(viewLifecycleOwner) {
                (binding.recyclerView.adapter as? HeroListAdapter)?.setList(it)
            }
            viewModel.getChars()
        }
        binding.favHeroes.setOnClickListener{
            viewModel.listFavChar.observe(viewLifecycleOwner) {
                (binding.recyclerView.adapter as? HeroListAdapter)?.setList(it)
            }
            viewModel.getFavouriteChar()
        }
        binding.recyclerView.run {
            adapter = HeroListAdapter(
                onClick = {
                    findNavController().navigate(ListFragmentDirections.actionListFragmentToCharacterDescription(it))

                }
            )
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

    }

}