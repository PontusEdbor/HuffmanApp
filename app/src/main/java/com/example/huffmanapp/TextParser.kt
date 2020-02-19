package com.example.huffmanapp

import java.util.*

class TextParser (){
    private var storedHashtable = Hashtable<Char,Int>()
    private var huffTree = HuffmanTree()
    /*fun parseText()
      counts instances of characters in input and returns hashtable
    */
    fun parseText(input: String): List<UByte> {
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
    fun compressText(input: String): List<UByte> {
        var compressedBinary = ""
        for (character in input){
            compressedBinary += huffTree.getCode(character)
        }
        val compressedBytes = toByteList(compressedBinary)
        return compressedBytes //Will actually have to compress also
    }
    private fun toByteList(input: String): List<UByte>{
        var resultList = mutableListOf<UByte>()
        //Divide into chunks of 8
        val chunkedInput = input.chunked(8)
        for (chunk in chunkedInput){
            resultList.add(decode(chunk).toUByte())
        }
        return resultList.toList()
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
    /*fun decompressText()

    */
    fun decompressText(input: List<UByte>) {
        val decompressedString = input.fold(""){acc, entry -> acc + encode(entry)}
        for (char in decompressedString){
            var foundChar = huffTree.takeStep(char)
            if (foundChar != null){
                print(foundChar)
            }
        }

        //return huffTree.printWholeText(decompressedString)
    }
    fun encode(input: UByte):String{
        var sum = input.toInt()
        var iterator = 1
        var value = ""
        while (iterator*2 <= sum){
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
        return value.padStart(8,'0')
    }
}