package com.example.disneyHeroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.disneyHeroes.characterlist.ListFragment
import com.example.disneyHeroes.databinding.FragmentAppstartBinding



class AppStartFragment : Fragment() {
    private lateinit var binding: FragmentAppstartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAppstartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStarted.setOnClickListener {
            findNavController().navigate(R.id.action_appStartFragment_to_listFragment)
//            parentFragmentManager.beginTransaction()
//                .setCustomAnimations(R.anim.anim_next_fragment, R.anim.anim_previous_fragment)
//                .replace(R.id.container, ListFragment())
//                .addToBackStack("")
//                .commit()
        }

    }
}