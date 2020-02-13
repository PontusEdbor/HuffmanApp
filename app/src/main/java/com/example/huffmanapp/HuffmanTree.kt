package com.example.huffmanapp

class HuffmanTree() {
    private var headNode:Node? = null
    private var stepperNode = headNode

    /*fun buildTree
      takes input of character weights and constructs tree
     */
    fun buildTree(input: Map<Int, Char>){
        println(input)
        var sortedInput = input.toList().sortedBy { (value, _) -> value }//Convert to list for easy sorting according to weight
        var nodeList = mutableListOf<Node>()

        nodeList = sortedInput.map { convertToNode(it) }.toMutableList()//List of nodes still in ascending order

        while (nodeList.size > 1){
            var fusedNode =  Node(
                nodeList[0],
                nodeList[1],
                nodeList[0].getWeight() + nodeList[1].getWeight())
            nodeList = nodeList.drop(2).toMutableList()
            nodeList.add(fusedNode)
            nodeList.sortBy { it.getWeight() }
        }
        headNode = nodeList[0]
    }

    /*fun printWeights()
      just helper
    */
    fun printWeights(input: MutableList<Node>): Unit {
        print("PRINTING WEIGHTS")
        for (entry in input){
            print(entry.getWeight())
        }
    }

    /*fun convertToNode()

    */
    fun convertToNode(input: Pair<Int, Char>): Node {
        var constructedNode = Node(input.first)
        constructedNode.setValue(input.second)
        return constructedNode
    }
    /* fun takeStep
    Assumes at least one step will be taken
    returns the Char of the node if any exist
     */
    fun takeStep(input: Char):Char?{
        if (headNode != null) {
            when (input) {//Add error catching
                '0' -> stepperNode = stepperNode?.destZero!!
                '1' -> stepperNode = stepperNode?.destOne!!
                else -> println("DISCARD NON BINARY DIGIT")
            }

            var nodeValue = stepperNode?.getValue()
            if (nodeValue != null) {
                stepperNode = headNode
            }
            return nodeValue
        }
        println("ERROR MISFORMED TREE")
        return input
    }

    inner class Node(private val weight: Int) {
        /*Required functions
        * Set Destinations
        * Get Destinations
        * Set value
        * Get Char value
        * Get weight
        *
        * If a node has a value then it does not have destinations
        * */
        constructor(zero: Node, one: Node, weight: Int) : this(weight) {
            this.destZero = zero
            this.destOne = one
        }
        private var value: Char? = null
        var destZero:Node? = null
        var destOne:Node? = null

        fun getWeight(): Int{
            return weight
        }
        fun getValue():Char?{
            return value
        }
        fun setValue(input: Char) {
            value = input
        }
    }
}
