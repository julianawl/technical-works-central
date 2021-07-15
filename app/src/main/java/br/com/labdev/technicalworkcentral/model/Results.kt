package br.com.labdev.technicalworkcentral.model

import java.io.Serializable

data class Results(
    val id: Int,
    val titulo: String,
    val ano_publicacao: Int,
    val resumo: String,
    val nomeOrientador: String,
    val urlArquivo: String
): Serializable