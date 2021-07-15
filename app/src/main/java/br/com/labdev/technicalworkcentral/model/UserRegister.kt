package br.com.labdev.technicalworkcentral.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserRegister(
    @SerializedName("nome") val name: String,
    @SerializedName("sobrenome") val lastName: String,
    @SerializedName("senha") val password: String,
    @SerializedName("email") val email: String
): Serializable