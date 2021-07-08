package br.com.labdev.technicalworkcentral.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.labdev.technicalworkcentral.databinding.FragmentResultsBinding
import br.com.labdev.technicalworkcentral.model.Article
import br.com.labdev.technicalworkcentral.ui.home.adapter.ResultsAdapter
import br.com.labdev.technicalworkcentral.ui.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultsFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResults()
    }

    private fun setResults() {
        val results: MutableList<Article> = mutableListOf()
        binding.resultsRv.apply {
            adapter = ResultsAdapter(results)
            this.layoutManager = LinearLayoutManager(requireContext(),
                verticalFadingEdgeLength, false)
        }
    }
}