package br.com.labdev.technicalworkcentral.model

import java.io.Serializable

data class Article(
    val year: String,
    val articleTitle: String,
    val author: UserRegister,
    val mentor: UserRegister,
    val studyArea: String,
    val course: String
): Serializable
