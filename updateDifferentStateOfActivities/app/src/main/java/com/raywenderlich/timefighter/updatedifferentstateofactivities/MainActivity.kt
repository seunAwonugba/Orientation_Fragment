package com.raywenderlich.timefighter.updatedifferentstateofactivities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /**
     * Declare an initial value for both orientation and portraite value
     */

    internal var count = 0;

    /**
     *Declare a variable that creates an instance of the text view that updates states
     */
    internal lateinit var stateUpdate: TextView
    internal lateinit var orientationUpdate: TextView
    internal lateinit var getPortraitTextView: TextView;
    internal lateinit var getLandscapeTextView: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var getScreenOrientation:Int = resources.configuration.orientation
        var mainValue = "";
        if (getScreenOrientation==1){
            mainValue = "Portrait"
            count++
        }
        else{
            mainValue = "Landscape"
            count+=1;
        }


        /**
         * Grab the id of the textview that updates state change and orientationchange
         */

        stateUpdate = findViewById(R.id.stateChangeId);
        orientationUpdate = findViewById(R.id.orientationId)
        getLandscapeTextView = findViewById(R.id.landscapeId)
        getPortraitTextView = findViewById(R.id.portraitId)

        /**
         * writes on textviews
         */

        stateUpdate.text = getString(R.string.stateUpdate);
        orientationUpdate.text = getString(R.string.orientation,mainValue);
        getLandscapeTextView.text = getString(R.string.landscapeValue,count);
        getPortraitTextView.text = getString(R.string.portraitValue,count);
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