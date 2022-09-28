package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val score = MutableLiveData(0)
    val currentWordCount = MutableLiveData(0)
    private var _currentScrambledWord = "test"

    private var wordsList : MutableList<String> = mutableListOf()
    private lateinit var currentWord : String

//    val score get() = _score.value
//    val currentWordCount : Int get() = _currentWordCount
    val currentScrambledWord : String get() = _currentScrambledWord

    init {
        Log.d("log","GameViewmodel Created")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()

        while(String(tempWord).equals(currentWord,false)) {
            tempWord.shuffle()
        }

        if(wordsList.contains(currentWord)){
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            currentWordCount.value = currentWordCount.value?.plus(1)
            wordsList.add(currentWord)
        }

    }

    /**
    * Returns true if the current word count is less than MAX_NO_OF_WORDS.
    * Updates the next word.
    */
    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }


    private fun increaseScore() {
        score.value = score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
* Re-initializes the game data to restart the game.
*/
    fun reinitializeData() {
        score.value = 0
        currentWordCount.value = 0
        wordsList.clear()
        getNextWord()
    }


}