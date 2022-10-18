package com.moejehad.firstkmm.android.note_list

import com.moejehad.firstkmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
