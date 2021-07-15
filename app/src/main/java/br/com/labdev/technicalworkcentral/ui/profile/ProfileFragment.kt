package br.com.labdev.technicalworkcentral.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.labdev.technicalworkcentral.R
import br.com.labdev.technicalworkcentral.data.Cache
import br.com.labdev.technicalworkcentral.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private val viewModel by viewModel<ProfileViewModel>()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val controller by lazy { findNavController() }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onResume() {
        super.onResume()
        if(isNotLogged()){
            controller.navigate(R.id.loginFragment)
        }
    }

    private fun isNotLogged(): Boolean {
        return Cache(requireContext()).has(Cache.ISLOGGED).isBlank()
    }
}