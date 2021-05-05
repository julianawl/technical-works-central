package br.com.labdev.technicalworkcentral.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.labdev.technicalworkcentral.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dialogView = layoutInflater.inflate(R.layout.dialog_filter, null)
        filter_btn.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Filtrar")
                .setView(dialogView)
                .setPositiveButton("OK"){ dialog, _ ->
                    dialog.dismiss()
                }
                .setNeutralButton("CANCEL"){ dialog, _ ->
                    dialog.dismiss()
                }.show()

        }
    }
}