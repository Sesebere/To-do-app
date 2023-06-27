package com.example.metask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @ColumnInfo
    var message: String,
    @ColumnInfo
    var priority: Priority,
    @ColumnInfo
    var dueDate: String,
    @ColumnInfo
    var duration: String,
    @ColumnInfo
    var order: Int,
    @ColumnInfo
    var isCompleted: String = "false",
    @ColumnInfo
    var isRepetitive: String = "false",
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)