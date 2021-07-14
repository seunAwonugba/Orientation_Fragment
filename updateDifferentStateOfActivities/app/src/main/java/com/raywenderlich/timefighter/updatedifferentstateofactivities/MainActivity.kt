package com.raywenderlich.timefighter.updatedifferentstateofactivities

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /**
     * Declare an initial value for both orientation and portraite value
     */
    var countPortrait = 0;
    var countLandscape = 0;


    /**
     *Declare a variable that creates an instance of the text view that updates states
     */
    internal lateinit var stateUpdate: TextView
    internal lateinit var orientationUpdate: TextView
    internal lateinit var getPortraitTextView: TextView;
    internal lateinit var getLandscapeTextView: TextView;

    /**
     * On save Instant state that handles changes in orientation, NOTE I USED KEY VALUE PAIR METHOD
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("portrait", countPortrait)
        outState.putInt("landscape", countLandscape)
    }

    /**
     * Default onCreate
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPortraitTextView = findViewById(R.id.portraitId)
        getLandscapeTextView = findViewById(R.id.landscapeId)


        /**
         * formular or code that gets screen orientation, and saved inside a variable
         */
        var getScreenOrientation:Int = resources.configuration.orientation

        /**
         * Check for change in the on save instance state and assign to the counts variable
         */

        if (savedInstanceState != null){
            countPortrait = savedInstanceState?.getInt("portrait")
            countLandscape = savedInstanceState?.getInt("landscape")
        }

        /**
         * Empty varaible that stores orientation change value
         */
        var mainValue = "";

        /**
         * Check per orientation
         */
        if (getScreenOrientation==1){
            mainValue = "Portrait"
            countPortrait++

            getPortraitTextView.text = getString(R.string.portraitValue,countPortrait);
            getLandscapeTextView.text = getString(R.string.landscapeValue,countLandscape);
        }
        else{
            mainValue = "Landscape"
            countLandscape++
            getPortraitTextView.text = getString(R.string.portraitValue,countPortrait);
            getLandscapeTextView.text = getString(R.string.landscapeValue,countLandscape);
        }


        /**
         * Grab the id of the textview that updates state change and orientationchange
         */

        stateUpdate = findViewById(R.id.stateChangeId);
        orientationUpdate = findViewById(R.id.orientationId)



        /**
         * writes on textviews
         */

        stateUpdate.text = getString(R.string.stateUpdate);
        orientationUpdate.text = getString(R.string.orientation,mainValue);


    }
    override fun onStart() {
        super.onStart()
        stateUpdate.setText("onStart")

    }

    override fun onResume() {
        super.onResume()
        stateUpdate.setText("onResume")
    }

    override fun onPause() {
        super.onPause()
        stateUpdate.setText("onPause")
    }

    override fun onStop() {
        super.onStop()
        stateUpdate.setText("onStop")

    }

    override fun onRestart() {
        super.onRestart()
        stateUpdate.setText("onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        stateUpdate.setText("onDestroy")
    }


}