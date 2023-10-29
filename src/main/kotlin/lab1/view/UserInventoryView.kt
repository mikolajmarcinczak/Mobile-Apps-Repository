package com.mobile.lab1.view

import com.mobile.lab1.controller.InventoryController
import com.mobile.lab1.model.Item
import com.mobile.lab1.model.ItemType
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class UserInventoryView : ViewBase("Player Inventory") {
  private val controller: InventoryController by inject()

  private val selectedItems = SimpleListProperty<Item>()

  override val root = borderpane {
    center {
      tableview(controller.showInventory()) {
        column("Name", Item::nameProperty)

        for (item in selectedItems) {
          val selectedItemProperty = SimpleObjectProperty<Item>()
          bindSelected(selectedItemProperty)
        }

        contextmenu {
          item("Remove") {
            action {
              val selectedItem = selectedItems.value.firstOrNull()
              if (selectedItem != null) {
                controller.removeItem(selectedItem)
              }
            }
          }
          item("Use") {
            action {
              val selectedItem = selectedItems.value.firstOrNull()
              if (selectedItem != null) {
                controller.useItem(selectedItem)
              }
            }
          }
          item("Show Description") {
            action {
              val selectedItem = selectedItems.value.firstOrNull()
              if (selectedItem != null) {
                controller.showItemDescription(selectedItem)
              }
            }
          }
        }
      }
    }
    bottom {
      hbox(10) {
        button("Add Item") {
          action {
            val newItem = Item(10, 12, "Nazwa", "Opis", ItemType.Ring)
            controller.addItem(newItem)
          }
        }
      }
    }
  }
}