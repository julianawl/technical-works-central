package br.com.labdev.technicalworkcentral.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.labdev.technicalworkcentral.R
import br.com.labdev.technicalworkcentral.databinding.FragmentLoginBinding
import br.com.labdev.technicalworkcentral.observe
import br.com.labdev.technicalworkcentral.ui.home.dialog.ForgotPasswordDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private val viewModel by viewModel<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val controller by lazy { findNavController() }
    private var forgotPasswordDialog: ForgotPasswordDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToRegister()
        forgotPassword()
        setLogin()
        inscribeObservers()
    }

    private fun goToRegister() {
        binding.tvRegister.setOnClickListener {
            controller.navigate(R.id.registerFragment)
        }
    }

    private fun forgotPassword(){
        binding.tvForgotPassword.setOnClickListener {
            forgotPasswordDialog = ForgotPasswordDialog()
            activity?.let {
                forgotPasswordDialog?.show(it.supportFragmentManager,
                    "Forgot Password Dialog")
            }
        }
    }

    private fun setLogin() {
        binding.btnLogin.setOnClickListener {
            val email: String = binding.tvEmailText.editableText.toString()
            val password: String = binding.tvPasswordText.editableText.toString()

            viewModel.validateCredentials(email, password)
        }
    }

    private fun inscribeObservers(){
        observe(viewModel.anythingIsBlankError){
            Toast.makeText(requireContext(), getString(R.string.blank_error_message), Toast.LENGTH_SHORT).show()
        }
        observe(viewModel.loginSucceed){
            goToProfile()
        }
    }

    private fun goToProfile() {
        controller.navigate(LoginFragmentDirections.actionLoginFragmentToNavigationProfile())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}