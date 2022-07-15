package com.example.mykotlin

fun main() {
    // class
    val car = Car("Blue","mDF")
    println(car.speed(100,199))
    println(car.drive())

    // inheritance class
    val truck = Truck("Orange","OGE")
    println(truck.speed(20,90))
    println(truck.drive())

    // interfaces
    val button = Button("Button")
    button.onClick("This is a button")
    val superMario = Character("Super Mario")
    superMario.onClick("This is an actor")

    // extension function
    println("Hello Jenny ".append("Friend"))
    println("Remove First And Last".removeFirstAndLast())

    // data class
    val person = Person(
        name = "Elad",
        lastName = "Sabag",
        age = 25
    )
    println(person.age)
}

// Class and Inheritance
open class Car(
    var color: String,
    var model: String) {

//    init {
//        if(color == "Blue")
//            println("Color is blue!")
//    }

    open fun drive() {
        println("Drive $model...vroooomm $color")
    }

    open fun speed(minSpeed: Int, maxSpeed: Int) {
        println("Min speed is: $minSpeed, Max speed is $maxSpeed")
    }
}

class Truck(color: String, model: String) : Car(color,model) {
    override fun speed(minSpeed: Int, maxSpeed: Int) {
        val fullSpeed = minSpeed*maxSpeed
        println("Truck full speed is $fullSpeed")
    }

    override fun drive() {
        println("vrooooom Truck")
    }
}

// Interfaces
interface ClickEvent {
    fun onClick(message: String)
}

class Button(val label: String): ClickEvent {
    override fun onClick(message: String) {
        println("Clicked by $label and here is a $message")
    }
}

class Character(val name: String) : ClickEvent {
    override fun onClick(message: String) {
        println("Clicked by $name and here is a message $message")
    }
}

// Extension Function
// both functions are equivalent
//fun String.append(toAppend: String): String = this.plus(toAppend)
fun String.append(toAppend: String): String {
    return this.plus(toAppend)
}
//fun String.removeFirstAndLast(): String = this.substring(1,this.length - 1)
fun String.removeFirstAndLast(): String {
    return this.substring(1,this.length - 1)
}

// Data Class
data class Person(val name: String, val lastName: String, val age: Int)