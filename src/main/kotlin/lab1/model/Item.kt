package com.mobile.lab1.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.intProperty
import tornadofx.stringProperty

open class Item(
    var durability: Int,
    var useCount: Int,
    val name: String,
    val description: String,
    val type: ItemType
) {
    val nameProperty = SimpleStringProperty(name)
    val descProperty = stringProperty(description)
    val typeProperty = SimpleStringProperty(this.type.toString())

    fun Use(): Boolean {
        return if (durability > 0) {
            this.useCount += 1
            this.durability -= 1
            println("$name used.")
            true
        }
        else {
            println("$name is broken and can no longer be used.")
            false
        }
    }

    fun getDetails() {
        println("Name: $name")
        println("Description: $description")
        println("Usage: $useCount")
        println("Uses left: $durability")
        println("Item type: $type")
    }
}

enum class ItemType {
    Sword,
    Staff,
    Mace,
    Bow,
    HandBallista,
    Ring,
    Incantation,
    Shovel,
    Hammer,
    HealPotion
}