package br.com.labdev.technicalworkcentral.model

import java.io.Serializable

data class User(
    val name: String,
    val pic: String,
    val socialMedia: List<SocialMedia>
): Serializable
