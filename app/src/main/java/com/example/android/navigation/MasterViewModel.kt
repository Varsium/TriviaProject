package com.example.android.navigation

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.navigation.Model.QuizQuestion

open class MasterViewModel : ViewModel() {
    //This class is used Globally in the project.
    val _quizKey = MutableLiveData<String>()
    val quizKey: LiveData<String> get() = _quizKey
    val _activeQuiz = MutableLiveData<ArrayList<QuizQuestion>>()
    val activeQuiz: LiveData<ArrayList<QuizQuestion>> get() = _activeQuiz
    val _multiQuizBundle = MutableLiveData<Bundle>()
    val multiQuizBundle: LiveData<Bundle> get() = _multiQuizBundle
    val _singleQuizBundle = MutableLiveData<Bundle>()
    val singleQuizBundle: LiveData<Bundle> get() = _singleQuizBundle
    val _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int> get() = _questionIndex
    val _numQuestions = MutableLiveData<Int>()
    val numQuestions: LiveData<Int> get() = _numQuestions
    var SafedTextMulti = ""
    var SafedTextSingle = ""

    init {
        _questionIndex.value = 0
        _numQuestions.value = 3
    }

}
