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

        return toAscii(compressedText) //Will actually have to compress also
    }
    private fun toAscii(input: String): String {
        var resultString = ""
        //Divide into chunks of 8
        val chunkedInput = input.chunked(8)
        //Decode to int
        for (chunk in chunkedInput){
            if (chunk.length <8){
                chunk.padEnd(8,'0')
            }
            //translate to ASCII
            resultString += decode(chunk).toInt().toChar()
            //Add to string
        }

        //return String
        return resultString
    }
    private fun decode(input: String): String{
        val reversedInput = input.reversed()
        var iteration = 1
        var value = 0
        for (digit in reversedInput){
            if (digit == '1'){
                value += iteration
            }
            iteration *= 2
        }
        return value.toString()
    }
    fun encode(input: String):String{
        var sum = input.toInt()
        var iterator = 1
        var value = ""
        while (iterator*2 < sum){
            iterator *= 2
        }
        while (iterator > 0){
            if (sum < iterator){
                iterator /= 2
                value += "0"
            }
            else {
                sum -= iterator
                iterator /= 2
                value += "1"
            }
        }
        return value
    }
    fun toDecompressAscii(input: String):String{
        var returnString = ""
        for (character in input){
            returnString += encode(character.toInt().toString()).padStart(8,'0')
        }
        return returnString
    }
    /*fun decomressText()

    */
    fun decompressText(input: String): String {
        return huffTree.printWholeText(toDecompressAscii(input))
    }
}