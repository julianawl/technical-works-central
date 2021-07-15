package br.com.labdev.technicalworkcentral.ui.home.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import br.com.labdev.technicalworkcentral.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ForgotPasswordDialog: DialogFragment() {

    var sendBtn: AppCompatButton? = null
    var emailField: TextInputEditText? = null
    var emailLayout: TextInputLayout? = null

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if(dialog!=null){
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setGravity(Gravity.CENTER_VERTICAL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.dialog_forgot_password, container)

        this.emailField = view?.findViewById(R.id.dialog_email_field)
        this.emailLayout = view?.findViewById(R.id.dialog_email_layout)
        this.sendBtn = view?.findViewById(R.id.dialog_recover_btn)

        val dialog = AlertDialog.Builder(activity)
        dialog.setView(view)

        this.sendBtn?.setOnClickListener {
            emailField?.clearFocus()
            val imgr = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imgr.hideSoftInputFromWindow(view?.windowToken, 0)

            val email = emailField?.text.toString()

            when{
                email.isEmpty() ->
                    Toast.makeText(requireContext(), "Campo vazio", Toast.LENGTH_SHORT).show()

                !Patterns.EMAIL_ADDRESS.matcher(email).find() ->
                    Toast.makeText(requireContext(), "Campo inválido", Toast.LENGTH_SHORT).show()
                else ->{
                    Toast.makeText(requireContext(), "Email enviado", Toast.LENGTH_SHORT).show()
                    closeDialog()
                }

            }
        }

        return rootView
    }

    private fun closeDialog(){
        dialog?.dismiss()
    }
}