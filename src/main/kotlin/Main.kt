package com.mobile

import com.mobile.lab1.*
import tornadofx.launch

fun main(args: Array<String>) {
    //zad 2.
    helloName()

    //zad 3.
    launch<InventoryManager>(args)
}