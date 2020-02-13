package com.example.huffmanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var huff = HuffmanTree()
        val theMap = mapOf(4 to 'l', 2 to 'o', 1 to ' ')
        println(theMap)

        val encodeButton = findViewById<Button>(R.id.button)
        encodeButton.setOnClickListener{
            //Click of the button should compress the text in the text view and send user to a new activity showing the compressed text and compression tree
            huff.buildTree(theMap)
        }
    }
}
