package com.mobile.lab1.view

import com.mobile.lab1.controller.InventoryController
import tornadofx.View
import tornadofx.borderpane
import tornadofx.center

class MainView : View("Main View") {
  private val inventoryController: InventoryController by inject()

  override val root = borderpane() {
    center {
      add(UserInventoryView::class)
    }
  }
}