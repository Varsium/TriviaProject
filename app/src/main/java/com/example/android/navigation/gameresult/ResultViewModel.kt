package com.example.android.navigation.gameresult

import androidx.lifecycle.ViewModel
import com.example.android.navigation.masterViewModel

class ResultViewModel : ViewModel() {
    private var lijstItems = ArrayList<String>()

    fun fillingViewList(): ArrayList<String> {
        println(masterViewModel.activeQuiz.value!!.size)
        for (i in 0 until masterViewModel.activeQuiz.value!!.size) {
            lijstItems.add("Question: " + masterViewModel.activeQuiz.value!![i].Question)
            lijstItems.add("Correct awnser: " + masterViewModel.activeQuiz.value!![i].Correctawnser)
        }
        return lijstItems
    }
}
