package com.example.mykotlin

import java.io.IOException
import java.lang.NullPointerException

fun main() {
    // Generics
    val listOfItems = listOf("Rafael","Gina","George","Elad")
    val listOfNumbers = listOf(1,5,2,7)
    val finder1 = Finder(list = listOfItems)
    val finder2 = Finder(list = listOfNumbers)
    finder1.findItem("Elad") {
        println("Found $it")
    }
    finder2.findItem(5) {
        println("Found $it")
    }

    // Enums & States & Abstract & Sealed Classes
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(result = Repository.getCurrentState())
    Repository.error()
    getResult(result = Repository.getCurrentState())
    Repository.anotherCustomFailure()

    getResult(result = Repository.getCurrentState())
    Repository.customFailure()
    getResult(result = Repository.getCurrentState())
}

// Generics
class Finder<T>(private val list: List<T>) {
    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter {
            it == element
        }
        if(itemFoundList.isNullOrEmpty())
            foundItem(null)
        else
            foundItem(itemFoundList.first())
    }
}

// Enums && State
fun getResult(result: Result) {
    return when(result) {
        is Error -> {
            println(result.exception.toString())
        }
        is Success -> {
            println(result.dataFetched?: "Ensure you start fetch function first")
        }
        is Loading -> {
            println("Loading...")
        }
        is NotLoading -> {
            println("Idle")
        }
        is Failure.CustomFailure -> {
            println(result.customFailure.toString())
        }
        is Failure.AnotherCustomFailure -> {
            println(result.anotherCustomFailure.toString())
        }
//        else -> {
//            println("N/A")
//        }
    }
}

//enum class Result {
//    SUCCESS,
//    ERROR,
//    IDLE,
//    LOADING
//}

object Repository {
    private var loadState: Result = NotLoading
    private var dataFetched: String? = null
    fun startFetch() {
        loadState = Loading
        dataFetched = "data"
    }
    fun finishedFetch() {
        loadState = Success(dataFetched)
        dataFetched = null
    }
    fun error() {
        loadState = Error(Exception())
    }
    fun getCurrentState() : Result = loadState
    fun customFailure() {
        loadState = Failure.CustomFailure(IOException("Custom failure"))
    }
    fun anotherCustomFailure() {
        loadState = Failure.AnotherCustomFailure(NullPointerException("Something went wrong"))
    }
}

// Abstract
//abstract class Result

// Sealed
sealed class Result

data class Success(val dataFetched: String?): Result()
data class Error(val exception: Exception): Result()
object NotLoading: Result()
object Loading: Result()

sealed class Failure: Result() {
    data class CustomFailure(val customFailure: IOException): Failure()
    data class AnotherCustomFailure(val anotherCustomFailure: NullPointerException): Failure()
}