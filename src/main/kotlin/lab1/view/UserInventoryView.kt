package com.mobile.lab1.view

import com.mobile.lab1.controller.InventoryController
import com.mobile.lab1.model.Item
import com.mobile.lab1.model.ItemType
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class UserInventoryView : ViewBase("Player Inventory") {
  private val controller: InventoryController by inject()

  private val items = controller.showInventory()
  private val selectedItems = SimpleListProperty<Item>(items)
  private val selectedItemProperty = SimpleObjectProperty<Item>()

  override val root = borderpane {
    center {
      tableview(controller.showInventory()) {
        column("Name", Item::nameProperty)
        column("Description", Item::descProperty)
        column("Durability", Item::durability)
        column("Use count", Item::useCount)
        column("Type", Item::typeProperty)
        bindSelected(selectedItemProperty)

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
    right {
      vbox(10.0) {
        button("Dodaj przedmiot") {
          action {
            val newItem = Item(10, 0, "Ring of Power", "cold stuff", ItemType.Ring)
            items.add(newItem)
          }
        }

        button("Usuń przedmiot") {
          action {
            val selectedItem = selectedItemProperty.get()
            if (selectedItem != null) {
              items.remove(selectedItem)
            }
          }
        }

        button("Użyj przedmiotu") {
          action {
            val selectedItem = selectedItemProperty.get()
            if (selectedItem != null) {
              if (!selectedItem.Use()) {
                items.remove(selectedItem)
              }
            }
          }
        }

        button("Pokaż szczegóły") {
          action {
            selectedItemProperty.get()?.getDetails()
          }
        }
      }
    }
  }
}