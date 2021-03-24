package net.qpaysolutions.mywallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import net.qpaysolutions.mywallet.Database.RegisterDatabase
import net.qpaysolutions.mywallet.Database.RegisterEntity

class ViewModel(app: Application) : AndroidViewModel(app){

    fun insertUserInfo(entity: RegisterEntity){
        val userDao = RegisterDatabase.getInstance(getApplication())?.registerDatabaseDao
        userDao?.insertUser(entity)

    }

//    fun getUserInfo(entity: RegisterEntity){
//        val userDao = RegisterDatabase.getInstance(getApplication())?.registerDatabaseDao
//        userDao?.getUser("999009", "sadadad")
//    }

}