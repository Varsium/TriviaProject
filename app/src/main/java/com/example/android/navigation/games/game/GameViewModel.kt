package com.example.android.navigation.games.game

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.android.navigation.Controllers.KEY_MULTIQUIZ
import com.example.android.navigation.games.GamesViewModel
import com.example.android.navigation.Model.QuizQuestion
import com.example.android.navigation.masterViewModel
import timber.log.Timber

class GameViewModel : GamesViewModel() {

    private lateinit var listofRadio: ArrayList<String>
    private val setquiz = quizList.QuizMultipleChoice()
    private val _awnsers = MutableLiveData<MutableList<String>>()

    init {
        _awnsers.value = ArrayList()
    }

    fun checkingAwnser(id: Int) {
        if (id != -1) {
            if (listofRadio[id] == quizQuestion.Correctawnser) {
                if (masterViewModel._questionIndex.value!! < masterViewModel._numQuestions.value!!) {
                    _awnserCheck.value = true
                    masterViewModel._questionIndex.value = masterViewModel.questionIndex.value!!.plus(1)
                    resetTimer()
                }
                if (masterViewModel._questionIndex.value == masterViewModel.numQuestions.value) {
                    gameWon()
                }
            } else {
                gameOver()
            }
        }
    }


    fun setQuestionMultipleChoice(): QuizQuestion {
        if (quizKey != KEY_MULTIQUIZ) {
            quizKey = KEY_MULTIQUIZ
            masterViewModel._activeQuiz.value = setquiz
            setquiz.shuffle()
        }
        val quiz = setValuesQuestion(setquiz)
        masterViewModel._numQuestions.value = ((quizQuestion.awnsers.size + 2) / 2).coerceAtMost(3)
        quiz.awnsers = quiz.awnsers.shuffled()
        _awnsers.value = quiz.awnsers.toMutableList()
        checklistAnwser(quiz)
        keepMultiQuiz()
        return quiz
    }


    private fun checklistAnwser(quizQuestion: QuizQuestion) {
        listofRadio = ArrayList()
        for (element in quizQuestion.awnsers) {
            listofRadio.add(element)
        }

    }

  private  fun keepMultiQuiz(): Bundle {
        if (quizKey == KEY_MULTIQUIZ) {
            masterViewModel._quizKey.value = quizKey
        }
        return bundlingVariables()
    }

    override fun onCleared() {
        masterViewModel._multiQuizBundle.value = keepMultiQuiz()
        Timber.i(setquiz.size.toString())
        stopTimer()
        super.onCleared()
    }

}
