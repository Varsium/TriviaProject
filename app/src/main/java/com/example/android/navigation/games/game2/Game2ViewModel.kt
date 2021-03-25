package com.example.android.navigation.games.game2

import android.os.Bundle
import com.example.android.navigation.Controllers.KEY_SINGLEQUIZ
import com.example.android.navigation.Model.QuizQuestion
import com.example.android.navigation.games.GamesViewModel
import com.example.android.navigation.masterViewModel
import java.util.*

class Game2ViewModel : GamesViewModel() {

    private var setquiz = quizList.QuizSingleAwnser()

    fun checkAwnser(AntwoordText: String) {
        val antwoord = AntwoordText.toLowerCase(Locale.ROOT).trimEnd().trimStart()
        if (!antwoord.isBlank()) {
            if (antwoord == quizQuestion.Correctawnser.toLowerCase(Locale.ROOT)) {
                if (masterViewModel.questionIndex.value!! < masterViewModel.numQuestions.value!!) {
                    _awnserCheck.value = true
                    masterViewModel._questionIndex.value = masterViewModel.questionIndex.value!!.plus(1)
                  resetTimer()
                }
                if (masterViewModel.questionIndex.value == masterViewModel.numQuestions.value) {
                    gameWon()
                }
            } else {
                gameOver()
            }
        }
    }

    fun startQuiz(): QuizQuestion {
        if (quizKey != KEY_SINGLEQUIZ) {
            quizKey = KEY_SINGLEQUIZ
            masterViewModel._activeQuiz.value = setquiz
            setquiz.shuffle()
        }
        return setValuesQuestion(setquiz)
    }

    private fun keepSingleAwnserQuiz(): Bundle {
        if (quizKey == KEY_SINGLEQUIZ) {
            masterViewModel._quizKey.value = quizKey
        }
        return bundlingVariables()
    }


    override fun onCleared() {
        masterViewModel._singleQuizBundle.value = keepSingleAwnserQuiz()
        super.onCleared()
    }


}