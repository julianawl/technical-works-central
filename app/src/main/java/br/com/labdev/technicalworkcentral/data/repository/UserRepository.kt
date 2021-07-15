package br.com.labdev.technicalworkcentral.data.repository

import br.com.labdev.technicalworkcentral.data.Cache
import br.com.labdev.technicalworkcentral.data.Cache.Companion.ISLOGGED
import br.com.labdev.technicalworkcentral.data.service.Api
import br.com.labdev.technicalworkcentral.model.UserLogin
import br.com.labdev.technicalworkcentral.model.UserRegister
import retrofit2.Response

class UserRepository(private val cache: Cache) {

    suspend fun login(email: String, password: String): Response<Any>{
        val userInfo = UserLogin(email, password)
        val response = Api.invoke().login(userInfo)
        cache.insert(ISLOGGED,"LOGGED")
        when(response.code()){
            200 -> cache.insert(ISLOGGED,"LOGGED")
        }
        return response
    }

    suspend fun register(name: String, lastName: String, email: String, password: String): Response<Unit> {
        val userInfo = UserRegister(name = name, lastName = lastName, email = email, password = password)
        val response = Api.invoke().register(userInfo)
        when(response.code()){
            201 -> cache.insert(ISLOGGED,"LOGGED")
        }
        return response
    }
}