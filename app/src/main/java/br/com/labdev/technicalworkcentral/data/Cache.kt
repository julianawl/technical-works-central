package br.com.labdev.technicalworkcentral.data

import android.content.Context
import br.com.labdev.technicalworkcentral.BuildConfig

class Cache(private val context: Context): ICache{

    private val preferencesFileName = BuildConfig.APPLICATION_ID
    private val sharedPreferences = context.getSharedPreferences(preferencesFileName, 0)

    override suspend fun insert(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override suspend fun update(key: String, value: String) {
        insert(key, value)
    }

    override suspend fun delete(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override suspend fun get(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    override fun has(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

    companion object{
        const val ISLOGGED = "ISLOGGED"
    }

}

interface ICache{
    suspend fun insert(key: String, value: String)
    suspend fun update(key: String, value: String)
    suspend fun delete(key: String)
    suspend fun get(key: String) :String
    fun has(key: String) : String
}