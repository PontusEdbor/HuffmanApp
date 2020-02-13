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
            val testText = "I wish I could find the study I found on another sub earlier this week. They were investigating sexual dimorphism in humans, focusing on the hypothesis that human males are evolved to have powerful punches. The interesting bit was that when they measured arm cranking power, the weakest male was stronger than the strongest female. Other measures of upper body strength weren't as lop sided, but provided some evidence of sexual dimorphism.\n" +
                    "\n" +
                    "I take away two things from this. First, men just own us in upper body strength. That testosterone during puberty changes them in ways no weight lifting is ever going to counter act for us. Second: if a woman has to physically defend herself from a healthy man, she's going to need skill to pull it off. She won't brute strength her way to victory. It's a little upsetting to me as well, but it's better to understand the reality at the outset.\n" +
                    "\n" +
                    "Maybe you would enjoy competing in martial arts? If you want to go toe to toe with guys, you'll need skills to be competitive."
            var compressedText = textParser.parseText(testText)
            var uncompressedText = textParser.decompressText(compressedText)
            println(testText.length)
            println(compressedText.length)
            println(uncompressedText)
        }
    }
}
