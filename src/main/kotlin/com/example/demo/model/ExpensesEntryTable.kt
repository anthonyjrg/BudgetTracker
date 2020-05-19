package com.example.demo.model

import com.example.demo.util.toJavaLocalDate
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import java.time.LocalDate
import tornadofx.*

fun ResultRow.toExpensesEntry() = ExpensesEntry(
        this[ExpensesEntryTable.id],
        this[ExpensesEntryTable.entryDate].toJavaLocalDate(),
        this[ExpensesEntryTable.itemName],
        this[ExpensesEntryTable.itemPrice].toDouble()

)

object ExpensesEntryTable: Table(){
    val id = integer("id").autoIncrement().primaryKey()
    val entryDate = date("entry_date")
    val itemName = varchar("name", length = 50)
    val itemPrice = decimal("price", scale = 2, precision = 9)
}

class ExpensesEntry(id: Int, entryDate: LocalDate, itemName: String, itemPrice:Double){
    val idProperty = SimpleIntegerProperty(id)
    var id: Int by idProperty

    val entryDateProperty = SimpleObjectProperty<LocalDate>()
    var entryDate: LocalDate by entryDateProperty

    val itemNameProperty = SimpleStringProperty()
    var itemName: String by itemNameProperty


    val itemPriceProperty = SimpleDoubleProperty()
    var itemPrice: Double by itemPriceProperty

    override fun toString(): String {
        return "Expenses Entry(id: $id, date: $entryDate, item: $itemName)"
    }
}

class ExpensesEntryModel: ItemViewModel<ExpensesEntry>(){
    val id = bind{item?.idProperty}
    val entryDate = bind{item?.entryDateProperty}
    val itemName = bind{item?.itemNameProperty}
    val itemPrice = bind{item?.itemPriceProperty}
}