package com.example.notepad2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "notes")
data class Note (



    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "lastupdated")
    var lastUpdated: Date,

    @ColumnInfo(name = "text")
    var text: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id:Long? = null


    ):Parcelable