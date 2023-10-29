package com.mobile.lab1.model

import tornadofx.asObservable

class UserInventory {
  private val items = mutableListOf<Item>()
  private val username = String()

  fun addItem(item: Item) {
    items.add(item)
    println("${item.name} added to $username's inventory.")
  }

  fun removeItem(item: Item) {
    if (items.contains(item)){
      items.remove(item)
      println("${item.name} removed from $username's inventory.")
    }
    else {
      notInInventory(item)
    }
  }

  fun useItem(item: Item) {
    if (items.contains(item)) {
      if (!item.Use()){
        removeItem(item)
      }
    }
    else {
      notInInventory(item)
    }
  }

  fun showItemDescription(item: Item) {
    if (items.contains(item)) {
      item.getDetails()
    }
    else {
      notInInventory(item)
    }
  }

  fun showInventory(): List<Item> {
    for ((i, item) in items.withIndex()) {
      println("$i: $item.name")
    }

    return items.asObservable()
  }

  private fun notInInventory(item: Item) {
    println("${item.name} is not in $username's inventory.")
  }
}