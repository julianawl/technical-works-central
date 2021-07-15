package br.com.labdev.technicalworkcentral.data.service

import android.content.Context
import br.com.labdev.technicalworkcentral.model.UserRegister
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

const val BASE_URL = "https://knowledge-uri-sa.herokuapp.com/v2/api-docs"

interface Api {

    @POST("usuarios/cadastro")
    suspend fun register(@Body userInfo: UserRegister): Response<Any>

    companion object{
        private fun createClient():OkHttpClient{
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build()
        }

        operator fun invoke(context: Context? = null): Api{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createClient())
                .build()
                .create(Api::class.java)
        }
    }
}
