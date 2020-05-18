package com.example.demo.app

import com.example.demo.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(BudgetTrackerWorkspace::class, Styles::class){
    override fun start(stage: Stage) {
        super.start(stage)
        with(stage){
            width = 700.00
            height = 500.00

        }
    }
}