package com.mobile.lab1.controller

import com.mobile.lab1.model.Item
import com.mobile.lab1.model.UserInventory
import tornadofx.Controller
import tornadofx.asObservable

class InventoryController : Controller() {
  private val inventory = UserInventory()

  fun addItem(item: Item) {
    inventory.addItem(item)
  }

  fun removeItem(item: Item) {
    inventory.removeItem(item)
  }

  fun useItem(item: Item) {
    inventory.useItem(item)
  }

  fun showItemDescription(item: Item) {
    inventory.showItemDescription(item)
  }

  fun showInventory() = inventory.showInventory().asObservable()
}