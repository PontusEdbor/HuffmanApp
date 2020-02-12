package com.example.huffmanapp

class AutomatonTree() {
    private val headNode = AutomatonNode()

    fun translateCode(code: String){
        var character = findNode(code).getValue()
        if (character == null){
            println("TROW ERROR code not found")
        }
    }

    private fun findNode(code: String): AutomatonNode{
        var memoryNode = headNode
        for (char in code){
            //For every char remaining in code step to the appropriate node
            //If node does not exist then create it
            when (char){
                '0' -> {
                    if (memoryNode.destZero != null){
                        memoryNode = memoryNode.destZero!!
                    } else{
                        memoryNode = AutomatonNode()
                    }
                }
                '1' -> {
                    if (memoryNode.destOne != null){
                        memoryNode = memoryNode.destOne!!
                    } else {
                        memoryNode = AutomatonNode()
                    }
                }
                else -> {
                    println("TROW ERROR bad path")
                }
            }
        }
        return memoryNode
    }

    fun addNode(character: Char, code: String){
        var memoryNode = findNode(code)
        // After this then memoryNode will be the node for the inserted value
        // If the memory node value is not null then throw error
        if (memoryNode.getValue() == null){
            memoryNode.setValue(character)
        }
        else {
            println("TROW ERROR code already declared")
        }
    }
    private class AutomatonNode() {
        /*Required functions
                * Set Destinations
                * get Destinations
                * Set value
                * get Char value*/
        private var value: Char? = null
        var destZero:AutomatonNode? = null
        var destOne:AutomatonNode? = null

        fun getValue():Char?{
            return value
        }
        fun setValue(input: Char) {
            value = input
        }
    }
}
