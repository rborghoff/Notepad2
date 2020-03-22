package com.example.notepad2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.notepad2.database.NoteRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()
}