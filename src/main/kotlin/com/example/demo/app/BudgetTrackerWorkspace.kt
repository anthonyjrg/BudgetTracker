package com.example.demo.app

import javafx.scene.control.TabPane
import tornadofx.*

class BudgetTrackerWorkspace: Workspace("Budget Tracker Workspace", NavigationMode.Tabs){
    init {
        tabContainer.tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
    }
}