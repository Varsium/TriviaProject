package com.example.android.navigation.gameresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGameOverBinding

class GameOverFragment : ResultFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)
        setTitle()
        binding.apply {
            seeAwnsers.setOnClickListener {
                ListAnwers.adapter = createFragment()
                ListAnwers.visibility = View.VISIBLE
            }
            tryAgainButton.setOnClickListener { view: View ->
                view.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragment2ToTitleFragment())
            }
            return binding.root
        }
    }
}


