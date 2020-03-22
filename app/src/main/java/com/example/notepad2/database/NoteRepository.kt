package com.example.notepad2.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notepad2.model.Note

class NoteRepository (context: Context) {
    private val noteDao: NoteDao
     init {

         val database = NoteRoomDatabase.getDatabase(context)
         noteDao = database!!.noteDao()
     }
    fun getNotepad():LiveData<Note?>{
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note){
        noteDao.updateNote(note)
    }

}