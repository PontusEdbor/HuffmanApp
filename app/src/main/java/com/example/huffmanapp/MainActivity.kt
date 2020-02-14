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
            val testText = "Wild Wild West\n" +
                    "Wild Wild West, Jim West, desperado, rough rider\n" +
                    "No you don't want nada\n" +
                    "None of this, gun in this, brotha runnin this,\n" +
                    "Buffalo soldier, look it's like I told ya\n" +
                    "Any damsel that's in distress\n" +
                    "Be out of that dress when she meet Jim West\n" +
                    "Rough neck so go check the law and abide\n" +
                    "Watch your step with flex and get a hole in your side\n" +
                    "Swallow your pride, don't let your lip react,\n" +
                    "You don't wanna see my hand where my hip be at,\n" +
                    "With all of this, from the start of this,\n" +
                    "Runnin the game, James West tamin the west so remember the name\n" +
                    "Now who ya gonna call?\n"
            var compressedText = textParser.parseText(testText)
            print("Uncompressed Length: ")
            println(testText.length)
            print("Compressed Length: ")
            println(compressedText.size)
            println(compressedText)
            textParser.decompressText(compressedText)
        }
    }
}
