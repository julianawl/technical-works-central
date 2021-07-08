package br.com.labdev.technicalworkcentral.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.labdev.technicalworkcentral.R
import br.com.labdev.technicalworkcentral.databinding.FragmentLoginBinding
import br.com.labdev.technicalworkcentral.databinding.FragmentRegisterBinding
import br.com.labdev.technicalworkcentral.observe
import br.com.labdev.technicalworkcentral.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    private val viewModel by viewModel<RegisterViewModel>()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val controller by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRegister()
        inscribeObservers()
    }

    private fun setRegister() {
        val fullName = binding.tvNameText.editableText.toString()
        val email = binding.tvEmailRegisterText.editableText.toString()
        val password = binding.tvPasswordRegisterText.editableText.toString()
        val confirmPassword = binding.tvConfirmPasswordRegisterText.editableText.toString()

        viewModel.validateCredentials(fullName, email, password, confirmPassword)
    }

    private fun inscribeObservers(){
        observe(viewModel.anythingIsBlankError){
            Toast.makeText(requireContext(),
                "Campos obrigatórios vazios", Toast.LENGTH_SHORT).show()
        }
        observe(viewModel.emailIsInvalidError){
            Toast.makeText(requireContext(),
                "E-mail inválido", Toast.LENGTH_SHORT).show()
        }
        observe(viewModel.passwordIsInvalidError){
            Toast.makeText(requireContext(),
                "Senha deve ter no mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
        }
        observe(viewModel.passwordIsDifferentError){
            Toast.makeText(requireContext(),
                "Senhas diferentes", Toast.LENGTH_SHORT).show()
        }
        observe(viewModel.registerSucceed){
            goToProfile()
        }
    }

    private fun goToProfile() {
        controller.navigate(RegisterFragmentDirections.actionRegisterFragmentToNavigationProfile())
    }
}