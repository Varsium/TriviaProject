package com.example.android.navigation.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.navigation.Controllers.KEY_SECOND
import com.example.android.navigation.Controllers.Timer
import com.example.android.navigation.DataSource.QuizList
import com.example.android.navigation.Model.QuizQuestion
import com.example.android.navigation.masterViewModel

open class VariableGamesViewModel : ViewModel() {
    //This class is purely with variables to keep it clean
    var quizKey = "is the key"
    var multiPlayed = false
    var singlePlayed = false
    val quizList: QuizList = QuizList()
    var quizQuestion: QuizQuestion = QuizQuestion()
    val _timeleft = MutableLiveData<Int>()
    val timeleft: LiveData<Int> get() = _timeleft
    val _question = MutableLiveData<String>()
    val question: LiveData<String> get() = _question
    val _awnserCheck = MutableLiveData<Boolean>()
    val awnserCheck: LiveData<Boolean>
        get() = _awnserCheck
    val _gameOver = MutableLiveData<Boolean>()
    val gameOver: LiveData<Boolean>
        get() = _gameOver
    val _gameWon = MutableLiveData<Boolean>()
    val gameWon: LiveData<Boolean>
        get() = _gameWon

    init {
        _question.value = ""
        _gameWon.value = false
        _gameOver.value = false
        _timeleft.value = 12
    }
}