package br.com.labdev.technicalworkcentral

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T : Any> Fragment.observe(liveData: LiveData<T>, block: (T) -> Unit){
    liveData.observe(viewLifecycleOwner,{
        block(it)
    })
}