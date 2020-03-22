package com.example.notepad2.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.notepad2.R

import kotlinx.android.synthetic.main.activity_edit_notepad.*
import kotlinx.android.synthetic.main.content_edit_notepad.*
import java.util.*

class EditNotepadActivity : AppCompatActivity() {
    private lateinit var editViewModel: EditNotepadActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_notepad)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Edit Notepad"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
        initViewModel()

    }
    private fun initViews() {
        fab.setOnClickListener {

            editViewModel.note.value?.apply {
               title = etTitle.text.toString()
                lastUpdated = Date()
                text = etNotes.text.toString()
            }

            editViewModel.updateNote()
        }
    }
    private fun initViewModel() {
        editViewModel = ViewModelProvider(this).get(EditNotepadActivityViewModel::class.java)
        editViewModel.note.value = intent.extras?.getParcelable(EXTRA_NOTE)!!

        editViewModel.note.observe(this, Observer { note ->
            if (note != null) {
                etTitle.setText(note.title)
                etNotes.setText(note.text)
            }
        })

        editViewModel.error.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        editViewModel.succes.observe(this, Observer { success ->
            if (success) finish()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> { // Used to identify when the user has clicked the back button
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }

}
