package net.qpaysolutions.mywallet.SignIn

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.qpaysolutions.mywallet.Database.RegisterRepository

class SigninViewModelFactory (
    private  val repository: RegisterRepository,
    private val application: Application):  ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SigninViewModel::class.java)) {
            return SigninViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}