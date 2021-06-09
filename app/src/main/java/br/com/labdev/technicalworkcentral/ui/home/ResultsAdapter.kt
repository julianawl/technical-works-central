package br.com.labdev.technicalworkcentral.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.labdev.technicalworkcentral.model.Results

class ResultsAdapter(
    val results: MutableList<Results> = mutableListOf()
): RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ResultsViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
}