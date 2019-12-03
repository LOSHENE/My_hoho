package com.example.myhoho

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //module-level variable

    private var like :Int = 0
    private var dislike :Int =0

    //declare an instance of the sharedpref
    private lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initialise the shared pref
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        imageView.setOnClickListener {
            like++

            textViewLike.text=like.toString()
        }


            imageView2.setOnClickListener {
            dislike++
            textViewDislike.text=dislike.toString()
        }

        Log.d( "MainActivity", "onCreate" )

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        //retrieve  the shared preferences
        like = sharedPreferences.getInt(getString(R.string.like),0)
        dislike=sharedPreferences.getInt(getString(R.string.dislike),0)
        textViewLike.text = like.toString()
        textViewDislike.text = dislike.toString()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),like)
            putInt(getString(R.string.dislike),dislike)
            apply()

        }
        Log.d( "MainActivity", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d( "MainActivity", "onDestroy")
        super.onDestroy()
    }
}
