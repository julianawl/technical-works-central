package br.com.labdev.technicalworkcentral.model

data class User(
    val name: String,
    val pic: String,
    val socialMedia: List<SocialMedia>
)
