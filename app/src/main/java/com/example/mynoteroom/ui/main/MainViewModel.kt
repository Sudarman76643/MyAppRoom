package com.example.mynoteroom.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mynoteroom.database.Note
import com.example.mynoteroom.repository.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mNoteRepository: NoteRepository = NoteRepository(application)
    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}
