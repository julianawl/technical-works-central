package br.com.labdev.technicalworkcentral.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.labdev.technicalworkcentral.R
import br.com.labdev.technicalworkcentral.ui.home.dialog.FilterDialog
import br.com.labdev.technicalworkcentral.ui.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val controller by lazy { findNavController() }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filter_btn.setOnClickListener {
            val filterDialog = FilterDialog()
            filterDialog.show(
                requireActivity().supportFragmentManager, "filter-dialog"
            )
            filterDialog.informedFilters = { _,_,_,_,_,_ ->
                //TODO viewmodel
            }
        }
        search_btn.setOnClickListener {
            goToResultsFragment()
        }
    }

    private fun goToResultsFragment() {
        controller.navigate(HomeFragmentDirections.actionNavigationHomeToResultsFragment())
    }

}