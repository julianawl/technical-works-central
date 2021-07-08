package br.com.labdev.technicalworkcentral.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.labdev.technicalworkcentral.data.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _anythingIsBlankError = MutableLiveData<Unit>()
    val anythingIsBlankError = _anythingIsBlankError as LiveData<Unit>

    private val _credentialIsInvalidError = MutableLiveData<Unit>()
    val credentialIsInvalidError = _credentialIsInvalidError as LiveData<Unit>

    private val _loginSucceed = MutableLiveData<Unit>()
    val loginSucceed = _loginSucceed as LiveData<Unit>


    private fun doLogin(email: String, password:String){
        viewModelScope.launch {
            repository.login(email, password)
        }
        _loginSucceed.postValue(Unit)
    }

    fun validateCredentials(email: String, password: String){
        when{
            email.isBlank() || password.isBlank() ->
                _anythingIsBlankError.postValue(Unit)

            else -> doLogin(email, password)
        }
    }
}