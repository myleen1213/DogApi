package com.example.newdogapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    //create a view model that contains everthing in mainviewmoel.kt
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access the buttons
        val changeDogButton: Button = findViewById(R.id.nextButton)
       // val backButton: Button = findViewById((R.id.backButton))

        //access the imageholder and use picasso to pass data
viewModel.currentlyDisplayedDog.observe(this,
    {
        val mainImage: ImageView = findViewById(R.id.dogImageHolder)
        Picasso.with(this).load(it.imgSrcUrl).into(mainImage)

    })

        changeDogButton.setOnClickListener{
            viewModel.getNewDog()


        }
    }
}