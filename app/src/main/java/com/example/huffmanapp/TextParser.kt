package com.example.huffmanapp

import java.util.*
import kotlin.collections.HashMap

class TextParser (){
    private var storedHashtable = Hashtable<Char,Int>()
    private var huffTree = HuffmanTree()
    /*fun parseText()
      counts instances of characters in input and returns hashtable
    */
    fun parseText(input: String): String {
        var countingTable = Hashtable<Char,Int>()
        for (character in input){
            if (countingTable.containsKey(character)){
                countingTable.put(character, countingTable.get(character)?.plus(1))
            }
            else {
                countingTable.put(character,1)
            }
        }
        storedHashtable = countingTable
        huffTree.buildTree(countingTable)//Redundant
        return compressText(input)
    }
    /*fun compressText()
      inputs a string and returns the compressed string
    */
    fun compressText(input: String): String {
        var compressedText = ""
        for (character in input){
            compressedText += huffTree.getCode(character)
        }
        return compressedText //Will actually have to compress also
    }
    /*fun decomressText()

    */
    fun decompressText(input: String): String {
        return huffTree.printWholeText(input)
    }
}