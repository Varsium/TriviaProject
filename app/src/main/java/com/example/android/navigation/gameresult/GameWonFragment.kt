package com.example.android.navigation.gameresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : ResultFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        setTitle()
        binding.apply {
            seeAwnsers.setOnClickListener {
                ListAnwers.adapter = createFragment()
                ListAnwers.visibility = View.VISIBLE
            }
            binding.nextMatchButton.setOnClickListener { view: View ->
                view.findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToTitleFragment())
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}
