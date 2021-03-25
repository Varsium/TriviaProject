package com.example.android.navigation.games.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.navigation.Model.QuizQuestion
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentGameBinding
import com.example.android.navigation.masterViewModel


class GameFragment : Fragment() {
    private lateinit var gameViewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game, container, false)
        binding.lifecycleOwner = this
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.gameViewModel = gameViewModel
        setTitle()
        generateDynamicRadiobuttons(gameViewModel.setQuestionMultipleChoice())

        gameViewModel.gameOver.observe(viewLifecycleOwner, Observer { gameover ->
            if (gameover) {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment2())
            }
        })
        gameViewModel.gameWon.observe(viewLifecycleOwner, Observer { gamewon ->
            if (gamewon) {
                findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment())
            }
        })
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            gameViewModel.checkingAwnser(binding.questionRadioGroup.checkedRadioButtonId)
            gameViewModel.awnserCheck.observe(viewLifecycleOwner, Observer { isSucces ->
                if (isSucces) {

                    generateDynamicRadiobuttons(gameViewModel.setQuestionMultipleChoice())
                    setTitle()
                }
            })
        }
        return binding.root
    }

    private fun generateDynamicRadiobuttons(question: QuizQuestion) {
        binding.apply {
            questionRadioGroup.removeAllViews()
            questionRadioGroup.clearCheck()
            for (i in question.awnsers.indices) {
                val radioButton = RadioButton(activity)
                radioButton.id = i
                radioButton.text = question.awnsers[i]
                questionRadioGroup.addView(radioButton)

            }
        }
    }

    private fun setTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, masterViewModel.questionIndex.value!!.plus(1), 3)
    }
    override fun onResume() {
        gameViewModel.onResume()
        super.onResume()
    }
    override fun onPause() {
        gameViewModel.stopTimer()
        super.onPause()
    }
}
