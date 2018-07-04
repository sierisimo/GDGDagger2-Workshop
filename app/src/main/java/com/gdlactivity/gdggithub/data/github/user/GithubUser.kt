package com.gdlactivity.gdggithub.data.github.user

import android.annotation.SuppressLint
import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@JsonClass(generateAdapter = true)
@Parcelize
data class GithubUser(
    val login: String,
    val id: Long,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String, //"https://github.com/octocat",
    val organizations_url: String, //"https://api.github.com/users/octocat/orgs",
    val repos_url: String, //"https://api.github.com/users/octocat/repos",
    val events_url: String, //"https://api.github.com/users/octocat/events{/privacy}",
    val type: String, //"User",
    val name: String, //"The Octocat",
    val email: String?, //null,
    val bio: String?, //null,
    val public_repos: Int, //8,
    val public_gists: Long, //8,
    val followers: Long, //2295,
    val following: Long, //9,
    val created_at: String, //"2011-01-25T18:44:36Z",
    val updated_at: String //"2018-06-23T04:11:11Z"
) : Parcelable