package com.work.vladimirs.higher_order_functions

data class Grocery(val name: String, val category: String,
                   val unit: String, val unitPrice: Double,
                   val quantity: Int) {
}

fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetables", "1b", 3.0, 3),
        Grocery("Mushrooms", "Vegetables", "1b", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2))

    //Sum spent on vegetables
    val sumVeget = groceries
        .filter { it.category == "Vegetables" }
        .sumByDouble { it.quantity * it.unitPrice}
    println("Sum all vegetables = ${sumVeget}")

    //Name's list of all groceries, whose costs lower 5.0
    val listNameCheapGrocery = groceries
        .filter { it.unitPrice * it.quantity < 5.0 }
        .map { it.name }
    println("Names cheapest groceries: ${listNameCheapGrocery}")

    //Common costs by category
    groceries
        .groupBy { it.category }
        .forEach { it -> println("${it.key}: ${it.value.sumByDouble { it.unitPrice * it.quantity }}") }

    //Name of all groceries, then not in bottle and group by type (unit)
    groceries
        .filterNot { it.unit == "Bottle" }
        .groupBy { it.unit }
        .forEach { it ->
            println(it.key)
            it.value.forEach { println("  -${it.name}")}
        }
}