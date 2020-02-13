package com.example.huffmanapp

import java.util.*

class TextParser (){
    /*fun countCharacters()
      counts instances of characters in input and returns hashtable
    */
    fun countCharacters(input: String): Hashtable<Char, Int> {
        var countingTable = Hashtable<Char,Int>()
        for (character in input){
            if (countingTable.containsKey(character)){
                countingTable.put(character, countingTable.get(character)?.plus(1))
            }
            else {
                countingTable.put(character,1)
            }
        }
        return countingTable
    }
}