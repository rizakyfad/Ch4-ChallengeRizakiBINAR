package com.rizaki.ch4challengerizaki.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rizaki.ch4challengerizaki.database.RoomDB
import com.rizaki.ch4challengerizaki.model.Users
import com.rizaki.ch4challengerizaki.repository.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UsersRepository
    val insert: LiveData<String?>

    init {
        val usersDao = RoomDB.database(application).usersDao()
        repository = UsersRepository(application, usersDao)
        insert = repository._insert
    }

    fun insert(item: Users) = CoroutineScope(Dispatchers.IO).launch {
        repository.insert(item)
    }
}