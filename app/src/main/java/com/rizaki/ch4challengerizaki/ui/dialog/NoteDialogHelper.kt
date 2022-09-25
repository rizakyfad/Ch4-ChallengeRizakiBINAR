package com.rizaki.ch4challengerizaki.ui.dialog

import androidx.appcompat.app.AlertDialog
import com.rizaki.ch4challengerizaki.model.Notes

interface NoteDialogHelper {
    fun dialogInsertNote(listener: (notes: Notes, dialog: AlertDialog) -> Unit)
    fun dialogUpdateNote(notes: Notes, listener: (notes: Notes, dialog: AlertDialog) -> Unit)
    fun dialogDetailNote(notes: Notes)
    fun dialogDeleteNote(notes: Notes, listener: (notes: Notes, dialog: AlertDialog) -> Unit)
    fun dialogLogout(listener: (dialog: AlertDialog) -> Unit)
}