package com.example.android.navigation.Controllers

import android.os.CountDownTimer
import com.example.android.navigation.games.VariableGamesViewModel
import timber.log.Timber

open class Timer() : VariableGamesViewModel() {
    private var secondsCount = 12;
    lateinit var Timer: CountDownTimer;
    private var i = 0;

    fun startTimer() {
        Timer.start()
    }

    fun makeTimer() {
        Timer = object : CountDownTimer(_timeleft.value!!.toLong() * KEY_SECOND, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeleft.value = millisUntilFinished.toInt() / KEY_SECOND
                println("Time keeps on ticking: " + timeleft.value)
            }

            override fun onFinish() {
                _gameOver.value = true
            }
        }
    }

    fun stopTimer() {
        try {
            Timer.cancel()

        } catch (ex: UninitializedPropertyAccessException) {
            Timber.i("Your timer hasn't been cancelled")
        }
    }

    fun resetTimer() {
        Timer.cancel()
        _timeleft.value = 12
        makeTimer()
        Timer.start()
    }
}
