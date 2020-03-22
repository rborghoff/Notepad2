package com.example.notepad2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notepad2.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes LIMIT 1 ")
    fun getNotepad():LiveData<Note?>

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}