package com.example.android.navigation.games

import android.os.Bundle
import com.example.android.navigation.Controllers.*
import com.example.android.navigation.Model.QuizQuestion
import com.example.android.navigation.masterViewModel

open class GamesViewModel : Timer() {
    //Class with all "general" functions
    fun gameOver() {
        _gameOver.value = true
        stopTimer()
    }

    fun gameWon() {
        _gameWon.value = true
        stopTimer()
    }

    fun setValuesQuestion(setquiz: ArrayList<QuizQuestion>): QuizQuestion {
        val quiz = setquiz[masterViewModel.questionIndex.value!!]
        quizQuestion = quiz
        _question.value = quiz.Question

        return quiz
    }

    fun bundlingVariables(): Bundle {
        val outState = Bundle()
        outState.putString(KEY_QUIZTYPE, quizKey)
        outState.putInt(KEY_QUESTIONSAWNSERED, masterViewModel.questionIndex.value!!)
        outState.putInt(KEY_NUMOFQUESTIONS, masterViewModel._numQuestions.value!!)
        masterViewModel._quizKey.value = quizKey
        return outState
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
        masterViewModel._questionIndex.value = 0
    }

    fun onResume() {
        makeTimer()
        startTimer()
    }
}
