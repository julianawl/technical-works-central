package br.com.labdev.technicalworkcentral.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.labdev.technicalworkcentral.R
import br.com.labdev.technicalworkcentral.model.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_search.view.*

class ResultsAdapter(
    private val results: MutableList<Article> = mutableListOf()
): RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_search, parent, false)
        return ResultsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int = results.size

    inner class ResultsViewHolder(view: View): RecyclerView.ViewHolder(view){
        private lateinit var item: Article
        private val articleAuthor by lazy { itemView.article_author_name }
        private val articleTitle by lazy { itemView.article_title }
        private val authorPicture by lazy { itemView.author_profile_pic }

        fun bind(item: Article){
            this.item = item
            articleAuthor.text = item.author.name
            articleTitle.text = item.articleTitle
            Glide.with(itemView)
                .load(item.author)
                .centerCrop()
                .into(authorPicture)
        }
    }
}