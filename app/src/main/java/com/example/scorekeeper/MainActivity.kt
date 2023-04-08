package com.example.scorekeeper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

        private var mScore1 = 0
        private var mScore2 = 0

        private var mScoreText1: TextView? = null
        private var mScoreText2: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                mScoreText1 = findViewById(R.id.score_1)
                mScoreText2 = findViewById(R.id.score_2)

        if (savedInstanceState != null) {

                mScore1 = savedInstanceState.getInt(MainActivity.STATE_SCORE_1)
                mScore2 = savedInstanceState.getInt(MainActivity.STATE_SCORE_2)


                mScoreText1!!.setText(mScore1.toString())
                mScoreText2!!.setText(mScore2.toString())
        }

}

        fun decreaseScore(view: View) {

             val viewID = view.id
             when (viewID) {
                   R.id.decreaseTeam1 -> {
                      mScore1--
                      mScoreText1!!.text = mScore1.toString()
                   }
                   R.id.decreaseTeam2 -> {

                       mScore2--
                       mScoreText2!!.text = mScore2.toString()
                   }
             }
}

        fun increaseScore(view: View) {
                // Get the ID of the button that was clicked.
                val viewID = view.id
                when (viewID) {
                        R.id.increaseTeam1 -> {
                                // Increment the score and update the TextView.
                                mScore1++
                                mScoreText1!!.text = mScore1.toString()
                        }
                        R.id.increaseTeam2 -> {
                                // Increment the score and update the TextView.
                                mScore2++
                                mScoreText2!!.text = mScore2.toString()
                        }
                }
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.night_mode) {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }


    companion object {
        // Tags to be used as the keys in OnSavedInstanceState
        const val STATE_SCORE_1 = "Team 1 Score"
        const val STATE_SCORE_2 = "Team 2 Score"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(MainActivity.STATE_SCORE_1, mScore1)
        outState.putInt(MainActivity.STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }




}








