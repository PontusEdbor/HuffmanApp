package com.example.huffmanapp

class AutomatonTree() {
    private val headNode = AutomatonNode()

    fun addNode(character: Char, code: String){
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
                    println("TROW ERROR")
                }
            }
        }// After this then memoryNode will be the node for the inserted value
        // If the memory node value is not null then throw error
        if (memoryNode.value == null){
            memoryNode.value = character
        }
        else {
            println("TROW ERROR")
        }
    }
    private class AutomatonNode() {
        /*Required functions
                * Set Destinations
                * get Destinations
                * Set value
                * return Char value*/
        var value: Char? = null
            get() = null
            set(value) {
                field = value
            }
        var destZero:AutomatonNode? = null
            get() = field
            set(value) {
                field = value
            }
        var destOne:AutomatonNode? = null
            get() = field
            set(value) {
                field = value
            }
    }
}
