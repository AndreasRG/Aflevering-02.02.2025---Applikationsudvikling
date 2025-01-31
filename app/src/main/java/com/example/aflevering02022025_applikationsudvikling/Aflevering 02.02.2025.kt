package com.example.aflevering02022025_applikationsudvikling

fun main() {
    //Opgave 1
    println("Please enter your age: ")
    val age = readLine()?.toIntOrNull() // age is of type Int?
    if (age != null && age >= 18) {
        println("You are eligible to vote")
    } else if (age != null) {
        println("You are not eligible to vote")
    } else {
        println("ERROR: Please enter a valid number.")
    }

    //Opgave 2
    //SEE FUNCTIONS IN BOTTOM OF DOCUMENT
    println(maxNumber(1, 18, 8))
    println(minNumber(1, 18, -8))

    //Opgave 3
    val testList:List<Int> = listOf(2, 3, 4, 2, 5, 2, 1, 5, 6, 3, 3)
    println(calculateAverage(testList))

    //Opgave 4
    println("Please enter your CPR-number: ")
    val cpr = readLine()
    if (cpr != null) {
        println(cprChecker(cpr))
    } else {
        println("ERROR: Invalid input. Please enter a valid CPR number.")
    }

    //Opgave 5
    println(fizzBuzz())

    //Opgave 6
    println("Please enter first name:")
    val firstName = readLine()
    println("Please enter middle name:")
    val middleName = readLine()
    println("Please enter last name:")
    val lastName = readLine()

    if (firstName != null && middleName != null && lastName != null) {
        println(reformatedToAbbrevations(firstName, middleName, lastName))
    } else {
        println("ERROR: Invalid input. Please enter a valid first and last name.")
    }

    //Opgave 7
    println("Please type a number to grade:")
    val gradeInput = readLine()?.toIntOrNull()
    if (gradeInput != null) {
        println(gradeCalculator(gradeInput))
    } else {
        println("ERROR: Invalid input. Please enter a valid grade.")
    }

    //Opgave 8
    val filterListToLengthOfWords = { listName:List<String>, definedLength:Int ->
        val filteredList:MutableList<String> = listName.filter { it.length >= definedLength }.toMutableList()
        filteredList
    }
    val givenList:List<String> = listOf("Andreas", "Laura", "James", "Isa", "Finn", "Jane", "Lise", "Lone", "Marco", "Vanessa", "Franke")

    println("Please enter a number/length to filter list by:")
    val minimumLengthInput = readLine()?.toIntOrNull()
    if (minimumLengthInput != null) {
        println(filterListToLengthOfWords(givenList, minimumLengthInput))
    } else {
        println("ERROR: Invalid input. Please enter a valid number.")
    }


}

//FUNCTIONS SECTION
//Opgave 2 - Functions
fun maxNumber(value1:Int, value2:Int, value3:Int) :Int {
    var highestNumber:Int? = null
    if (value1 > value2 && value1 > value3) {
        highestNumber = value1
    } else if (value2 > value3) {
        highestNumber = value2
    } else {
        highestNumber = value3
    }
    return highestNumber
}

fun minNumber(value1:Int, value2:Int, value3:Int) :Int {
    var lowestNumber:Int? = null
    if (value1 < value2 && value1 < value3) {
        lowestNumber = value1
    } else if (value2 < value3) {
        lowestNumber = value2
    } else {
        lowestNumber = value3
    }
    return lowestNumber
}

//Opgave 3

fun calculateAverage(listName:List<Int> ) :Double {
    var averageNumber:Int = 0
    val listLoop:List<Unit> = listName.map { averageNumber = averageNumber + it }
    val averageNumberResult:Double = averageNumber.toDouble() / listName.size.toDouble()
    return averageNumberResult
}

//Opgave 4
fun cprChecker(cprInput:String) :Boolean {
    if (cprInput.length != 10){
        println("ERROR: Invalid CPR! Your CPR doesn't have the required length.")
        return false
    }
    val day:Int? = cprInput.substring(0, 2).toIntOrNull()
    val month:Int? = cprInput.substring(2, 4).toIntOrNull()

    if (day == null || day !in 1..31 || month == null || month !in 1..12) {
        println("ERROR: Invalid CPR! Your CPR doesn't have a valid date.")
        return false
    } else {
        println("CPR confirmed! Thanks for inserting a valid CPR!")
        return true
    }
}

//Opgave 5
fun fizzBuzz() :String {
    for (i in 1..100) {
        if (i % 5 == 0 && i % 3 == 0) {
            println("FizzBuzz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else if (i % 3 == 0) {
            println("Fizz")
        } else {
            println(i)
        }
    }
    return "Process completed!"
}

//Opgave 6
fun reformatedToAbbrevations(firstName:String, middleName:String, lastName:String) :String {
    var reformatedName:String = ""

    val firstNameLetter:String = firstName.substring(0, 1)
    val middleNameLetter:String = middleName.substring(0, 1)

    reformatedName = "Successfully created abbrevated name: $firstNameLetter. $middleNameLetter. $lastName"

    return reformatedName
}

//Opgave 7
fun gradeCalculator(grade:Int) :String {
    var gradeMessage:String = ""
    when (grade) {
        in 1..59 -> gradeMessage = "F"
        in 60..69 -> gradeMessage = "D"
        in 70..79 -> gradeMessage = "C"
        in 80..89 -> gradeMessage = "B"
        in 90..100 -> gradeMessage = "A"
    }
    return gradeMessage
}