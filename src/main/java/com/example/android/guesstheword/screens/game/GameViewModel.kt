package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {
    companion object {
        // These represent different important times
        // This is when the game is over
        const val DONE = 0L
        // This is the number of milliseconds in a second
        const val ONE_SECOND = 1000L
        // This is the total time of the game
        const val COUNTDOWN_TIME = 60000L
    }
    //private val timer : CountDownTimer
    var word = ""

    // The current score
     var score = MutableLiveData<Int>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    init {
        Log.i("gameviewmodel","gameview created!")
        resetList()
        nextWord()
        score.value = 0
        //timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
          //  override fun onTick(millisUntilFinished: Long) {
            //}

            //override fun onFinish() {
            //}
        //}
       // timer.start()//
      //  DateUtils.formatElapsedTime(newTime)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("gameviewmodel","gameviewmodel destroyed!")
    }
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {

        }
            word = wordList.removeAt(0)
    }
   fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

   fun onCorrect() {
       score.value = (score.value)?.plus(1)
        nextWord()
    }
}