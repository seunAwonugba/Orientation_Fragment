package com.raywenderlich.timefighter.addandremovefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

//    private val FRAGMENT_TAG: String? = "FRAGMENT_TAG"

    private val FRAGMENT_TAG: String? = "FRAGMENT_TAG"

    /**
     * Grab Buttons by Class
     */

    internal lateinit var grabAddButton : Button
    internal lateinit var grabRemoveButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Grab Buttons by ID
         */

        grabAddButton = findViewById(R.id.addButtonId)
        grabRemoveButton = findViewById(R.id.removeButtonId)

        /**
         * Add Event listeners to the buttons
         */
        grabAddButton.setOnClickListener{view ->functionAddFragment()}

        grabRemoveButton.setOnClickListener{view-> functionRemoveFragment()}

    }

    /**
     * Create functions that will be called when you click on the button
     */
    private fun functionAddFragment(){
        supportFragmentManager.beginTransaction().add(R.id.fragmentLayoutId,BlankFragment(),FRAGMENT_TAG).commit()

    }

    private fun functionRemoveFragment(){
        supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)

    }
}