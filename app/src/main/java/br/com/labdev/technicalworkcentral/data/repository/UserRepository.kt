package br.com.labdev.technicalworkcentral.data.repository

import br.com.labdev.technicalworkcentral.data.service.Api
import br.com.labdev.technicalworkcentral.model.UserRegister

class UserRepository {
    suspend fun login(email: String, password: String){
        TODO()
    }

    suspend fun register(name: String, lastName: String, email: String, password: String): Any{
        val userInfo = UserRegister(name, lastName, email, password)
        return Api.invoke().register(userInfo)
    }
}