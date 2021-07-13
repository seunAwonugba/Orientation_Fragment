package com.raywenderlich.timeFighter.seunAwonugba

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     * Initial Text Score
     */
    internal var score = 0;


    /**
     * Declare variables to instantiate Button class and TextView class
     */
    internal lateinit var tapMeButton:Button
    internal lateinit var scoreTextView: TextView
    internal lateinit var timeLeftView: TextView

    internal var gameStarted = false

    /**
     * For the second text view, instantiate a countdow timer class
     */

    internal lateinit var instanceCountDownTimer: CountDownTimer

    /**
     * Initiate i.e assign a value where the count down begins
     */

    internal var countDownInitialValue: Long =  60000;
    internal var countDownTimerInterval:Long = 1000;
    internal var timeLeftOnTimer:Long = 60000;

    companion object{
        private val TAG = MainActivity::class.java.simpleName
        private const val SCORE_KEY = "SCORE_KEY";
        private const val TIME_LEFT_KEY = "TIME_LEFT_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate is called: Score is $score")


        /**
         * Get each activity by ID
         */
        tapMeButton = findViewById(R.id.idTapMeButton)
        scoreTextView= findViewById(R.id.idGameScoreTextView)
        timeLeftView = findViewById(R.id.idTimeLeftTextView)

        /**
         * Add an onclick event listener to the button, and call the increment function
         */
        tapMeButton.setOnClickListener{
                view -> incrementScoreFunction()
        }

        /**
         * In the onStart function, set your initial score to zero
         */

//        onResetGame()
        if(savedInstanceState != null){
            score =savedInstanceState.getInt(SCORE_KEY)
            timeLeftOnTimer  = savedInstanceState.getLong(TIME_LEFT_KEY)
            restoreGame();
        }
        else{
            onResetGame()
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(SCORE_KEY,score);
        outState.putLong(TIME_LEFT_KEY,timeLeftOnTimer)
        instanceCountDownTimer.cancel();

        Log.d(TAG, "onSaveInstance state: Saving Score: $score & Time left: $timeLeftOnTimer")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }

    private fun onResetGame(){
        score = 0;
        scoreTextView.text = getString(R.string.yourScore,score)

        val defaultInitialCountTime = countDownInitialValue/1000;
        timeLeftView.text = getString(R.string.timeLeft,defaultInitialCountTime)

        instanceCountDownTimer = object :CountDownTimer(countDownInitialValue,countDownTimerInterval){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished
                val timeLeft = millisUntilFinished/1000;
                timeLeftView.text = getString(R.string.timeLeft,timeLeft)
            }

            override fun onFinish() {
                endGameMessageFunction()
            }
        }
        gameStarted = false
    }

    /**
     * restore game function
     */

    private fun restoreGame(){
        scoreTextView.text = getString(R.string.yourScore, score)

        val restoredTime = timeLeftOnTimer/1000
        timeLeftView.text = getString(R.string.timeLeft, restoredTime)

        instanceCountDownTimer = object :CountDownTimer(countDownInitialValue,countDownTimerInterval){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftOnTimer = millisUntilFinished;
                var timeLeft = millisUntilFinished/1000;
                timeLeftView.text = getString(R.string.timeLeft,timeLeft)
            }

            override fun onFinish() {
                endGameMessageFunction()
            }
        }

        instanceCountDownTimer.start();
        gameStarted = true
    }

    /**
     * Create an increment function, that increments scores on every click pss you have attached an
     * onClick event listener
     */

    private fun incrementScoreFunction() {
        if (!gameStarted){
            startGame()
        }

        score++
        val newScore = getString(R.string.yourScore,score);
        scoreTextView.text = newScore
    }

    private fun startGame(){
        instanceCountDownTimer.start();
        gameStarted = true
    }

    fun endGameMessageFunction(){
        Toast.makeText(this, getString(R.string.gameOverMessage,score), Toast.LENGTH_LONG).show()
        onResetGame()
    }
}