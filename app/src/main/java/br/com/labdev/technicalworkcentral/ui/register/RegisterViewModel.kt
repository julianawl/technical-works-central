package br.com.labdev.technicalworkcentral.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.labdev.technicalworkcentral.data.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(
    val repository: UserRepository
) : ViewModel() {

    private val _anythingIsBlankError = MutableLiveData<Unit>()
    val anythingIsBlankError = _anythingIsBlankError as LiveData<Unit>

    private val _credentialIsInvalidError = MutableLiveData<Unit>()
    val credentialIsInvalidError = _credentialIsInvalidError as LiveData<Unit>

    private val _emailIsInvalidError = MutableLiveData<Unit>()
    val emailIsInvalidError = _emailIsInvalidError as LiveData<Unit>

    private val _passwordIsInvalidError = MutableLiveData<Unit>()
    val passwordIsInvalidError = _passwordIsInvalidError as LiveData<Unit>

    private val _passwordIsDifferentError = MutableLiveData<Unit>()
    val passwordIsDifferentError = _passwordIsDifferentError as LiveData<Unit>

    private val _registerSucceed = MutableLiveData<Unit>()
    val registerSucceed = _registerSucceed as LiveData<Unit>


    private fun doRegister(name: String, lastName: String, email: String, password:String){
        viewModelScope.launch {
            val response = repository.register(name, lastName, email, password)
            when(response.code()){
                201 -> _registerSucceed.postValue(Unit)
                else -> _credentialIsInvalidError.postValue(Unit)
            }
        }
    }

    fun validateCredentials(name: String, lastName: String, email: String, password: String, confirmPassword: String){
        when{
            email.isBlank() || password.isBlank()
                    || name.isBlank() || lastName.isBlank()
                    || confirmPassword.isBlank() ->
                _anythingIsBlankError.postValue(Unit)

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                _emailIsInvalidError.postValue(Unit)

            password.length < 6 ->
                _passwordIsInvalidError.postValue(Unit)

            confirmPassword != password ->
                _passwordIsDifferentError.postValue(Unit)

            else -> doRegister(name, lastName, email, password)
        }
    }

}