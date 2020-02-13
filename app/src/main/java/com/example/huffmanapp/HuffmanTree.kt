package com.example.huffmanapp

class HuffmanTree() {
    private val headNode = Node()

    class Node() {
        /*Required functions
                * Set Destinations
                * get Destinations
                * Set value
                * get Char value*/
        private var value: Char? = null
        var destZero:Node? = null
        var destOne:Node? = null

        fun getValue():Char?{
            return value
        }
        fun setValue(input: Char) {
            value = input
        }
    }
}
