package com.example.mykotlin

fun main() {
    // #1 when
    val amount = 0
    when(amount) {
        in 1..100 -> print("this amount is between 1 and 100")
        !in 10..99 -> print("this amount is not between 10 and 99")
        999 -> print("you are getting there...")
        else ->
            print("amount is $amount")
    }

    // #2 for
    for(i in 1..1000) {
        if(i % 3 == 0)
            println(i)
    }

    // #3 function with parameters
//    calculate

    // #4 function with return value
    println(calculateCatAge(5))

    // #5 lambda function
//     val lambadaName: Type = { parameterList -> codeBody }
    val sum: (Int, Int) -> Int = {
            a,b -> a + b
    }
    val catAge1: (Int) -> Int = {
        a -> a*7
    }

    // #6 lambda function with it - only with one parameter
    val catAge2: (Int) -> Int = {
        it * 7
    }

    // #7 lambda function without return value
    val name1: (String) -> Unit = {
        a -> print(a)
    }
    val name2: (String) -> Unit = {
            print(it)
    }
    name1("Elad")
    name2("Elad")

    // #8 trailing lambda - function as parameter
    enhancedMessage("Hello there,") {
        print(it)
        add(12,12)
    }

    // #9 collections - listOf
    val myListOfNames = listOf("Elad","Sabag","Programmer")
    for(item in myListOfNames) {
        println(item)
    }
    for(item in myListOfNames.indices) {
        println(myListOfNames[item])
    }
    myListOfNames.forEach {
        item -> println(item)
    }
        myListOfNames.forEach {
            print(it)
    }

    // #10 collections - mutable listOf
    val myMutableList = mutableListOf(12,34,45,123)
    myMutableList.add(214)
    print(myMutableList)
    myMutableList.remove(214)
    myMutableList.removeAt(0)
    print(myMutableList)
    print(myMutableList.get(0))

    // empty
    val myEmptyMutableList = mutableListOf<Any>()
    myEmptyMutableList.add("Elad")
    println(myEmptyMutableList.get(0))
    val myEmptyMutableIntegerList = mutableListOf<Int>()
    myEmptyMutableIntegerList.add(2)

    // #11 collections - sets
    // difference between sets and lists is that sets doesn't accept duplicates
    val mySet = setOf("US","MZ","AU","US")
    val myMutableSet = mutableSetOf(1,2,4,6,7)
    myMutableSet.add(4)
    println(mySet)
    println(myMutableSet)

    // #12 collections - map
    // again, difference between _Of and mutable_Of is the second can be changed
    val secretMap = mapOf("up" to 1, "down" to 2, "left" to 3, "right" to 4)
    println(secretMap)
    println(secretMap.values)
    println(secretMap.keys)
    if("up" in secretMap) println("Yes")
    if(4 in secretMap.values) println("Yes")
    val myMutableSecretMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    myMutableSecretMap.put("one",3)
    myMutableSecretMap.put("four",4)
    println(myMutableSecretMap)

    // #13 collections - initializing lists
    val myNewListAny = mutableListOf<Any>()
    val myNewListInt = mutableListOf<Int>()
    myNewListAny.add("Elad")
    myNewListAny.add(1)
    println(myNewListAny)
    myNewListInt.add(1)
    println(myNewListInt)

    // #14 collections - filter
    val myListOfNames2 = listOf("Elad","Sabag","Programmer")
    val foundNameList = myListOfNames2.filter {
        it == "Sabag"
    }
    val foundLengthList = myListOfNames2.filter {
        it.length > 4
    }
    println(myListOfNames2)
    println(foundNameList)
    println(foundLengthList)
}

val add: (Int,Int) -> Int = {
    a,b -> a+b
}

fun calculate(
    first: Int,
    second: Int,
    message: String,
    multipleOf: Int) {
    for(i in first..second) {
        if(i%3 == 0)
            println("$i $message $multipleOf")
    }
}

// both are equivalent
//fun calculateCatAge(age: Int) : Int = age * 7
fun calculateCatAge(age: Int) : Int {
    return age * 7
}

fun enhancedMessage(message: String, funAsParameter: (String) -> Int) {
    println("$message ${funAsParameter("Hey ")}")
}