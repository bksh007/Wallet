package net.qpaysolutions.mywallet.SignIn

import android.app.Application
import android.database.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import net.qpaysolutions.mywallet.Database.RegisterRepository

class SigninViewModel (private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {
    val users = repository.users

    @Bindable
    val inputUseremail = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    //Function triggered When the Login Button is Clicked, Via Binding.
    fun loginButton() {
        //-------Logic for the code
    }

    fun signUP() {
        //navigate to the Register Fragment
    }



//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) =
//        Unit
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//    }


}

