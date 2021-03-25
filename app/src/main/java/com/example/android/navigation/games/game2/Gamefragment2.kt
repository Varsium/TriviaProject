package com.example.android.navigation.games.game2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGame2Binding
import com.example.android.navigation.masterViewModel


class Gamefragment2 : Fragment() {
    private lateinit var binding: FragmentGame2Binding
    private lateinit var game2ViewModel: Game2ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game2, container, false)
        game2ViewModel = ViewModelProvider(this).get(Game2ViewModel::class.java)
        setTitle()
        binding.lifecycleOwner = this
        binding.apply {
            gameViewModel = game2ViewModel
            game2ViewModel.startQuiz()
            checkawnser.setOnClickListener {
                game2ViewModel.checkAwnser(AntwoordText.text.toString())
                game2ViewModel.awnserCheck.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    AntwoordText.text.clear()
                    game2ViewModel.startQuiz()
                    setTitle()
                })
            }
            game2ViewModel.gameOver.observe(viewLifecycleOwner, Observer { gameover ->
                if (gameover) {
                    findNavController().navigate(Gamefragment2Directions.actionGamefragment2ToGameOverFragment2())
                }
            })
            game2ViewModel.gameWon.observe(viewLifecycleOwner, Observer { gamewon ->
                if (gamewon) {
                    findNavController().navigate(Gamefragment2Directions.actionGamefragment2ToGameWonFragment())
                }
            })
            return binding.root
        }
    }

    private fun setTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_starwars_trivia_question, masterViewModel.questionIndex.value!!.plus(1), 3)
    }

    override fun onResume() {
        game2ViewModel.onResume()
        super.onResume()
    }

    override fun onPause() {
        game2ViewModel.stopTimer()
        super.onPause()
    }
}

