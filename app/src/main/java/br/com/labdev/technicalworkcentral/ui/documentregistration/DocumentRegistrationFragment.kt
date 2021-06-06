package br.com.labdev.technicalworkcentral.ui.documentregistration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.labdev.technicalworkcentral.R

class DocumentRegistrationFragment : Fragment() {

    private lateinit var documentRegistrationViewModel: DocumentRegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_document_registration, container, false)
    }

}