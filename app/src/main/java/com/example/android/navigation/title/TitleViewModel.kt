package com.example.android.navigation.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.navigation.Controllers.KEY_MULTIQUIZ
import com.example.android.navigation.Controllers.KEY_NUMOFQUESTIONS
import com.example.android.navigation.Controllers.KEY_QUESTIONSAWNSERED
import com.example.android.navigation.Controllers.KEY_SINGLEQUIZ
import com.example.android.navigation.masterViewModel

class TitleViewModel : ViewModel() {
    private val _textMulti = MutableLiveData<String>()
    val textMulti: LiveData<String> get() = _textMulti
    private val _textSingle = MutableLiveData<String>()
    val textSingle: LiveData<String> get() = _textSingle

    fun textMulti() {
        if (masterViewModel.quizKey.value == KEY_MULTIQUIZ) {
            _textMulti.value = "you have correctly awnsered " + masterViewModel.multiQuizBundle.value!!
                    .get(KEY_QUESTIONSAWNSERED).toString() +
                    " of the " + masterViewModel.multiQuizBundle.value!!.get(KEY_NUMOFQUESTIONS) + " Questions"
            masterViewModel.SafedTextMulti = textMulti.value.toString()
            println(masterViewModel.SafedTextMulti)
        } else {
            println(masterViewModel.SafedTextMulti)
            _textMulti.value = masterViewModel.SafedTextMulti
        }
    }

    fun textSingle() {
        if (masterViewModel.quizKey.value == KEY_SINGLEQUIZ) {
            _textSingle.value = "you have correctly awnsered " + masterViewModel.singleQuizBundle.value!!
                    .get(KEY_QUESTIONSAWNSERED).toString() +
                    " of the " + masterViewModel.singleQuizBundle.value!!.get(KEY_NUMOFQUESTIONS) + " Questions"
            masterViewModel.SafedTextSingle = textSingle.value.toString()
        } else {
            _textSingle.value = masterViewModel.SafedTextSingle
        }
    }


}