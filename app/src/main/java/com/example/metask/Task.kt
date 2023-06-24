package com.example.metask

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
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
    var isCompleted: String
)