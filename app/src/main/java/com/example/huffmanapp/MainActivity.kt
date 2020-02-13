package com.example.huffmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textParser = TextParser()

        val encodeButton = findViewById<Button>(R.id.button)
        encodeButton.setOnClickListener{
            //Click of the button should compress the text in the text view and send user to a new activity showing the compressed text and compression tree
            val testText = "This is a slightly longer text to try the functions on."
            var compressedText = textParser.parseText(testText)
            var uncompressedText = textParser.decompressText(compressedText)
            println(uncompressedText)
        }
    }
}
