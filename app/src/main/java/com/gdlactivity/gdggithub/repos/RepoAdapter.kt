package com.gdlactivity.gdggithub.repos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.data.github.repository.GithubRepository
import kotlinx.android.synthetic.main.item_repository.view.*

class RepoAdapter(private val repositoryList: List<GithubRepository>) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false))
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.setName(repositoryList[position].name)
        holder.setStarCount(repositoryList[position].stargazers_count)
        holder.setWatchCount(repositoryList[position].watchers_count)
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setName(name: String) {
            itemView.tvItRepoName.text = name
        }

        fun setStarCount(count: Long) {
            itemView.tvItRepoStar.text = "$count"
        }

        fun setWatchCount(count: Long){
            itemView.tvItRepoWatcher.text = "$count"
        }
    }
}