package com.gdlactivity.gdggithub.data.github

data class GitHubAPIEndoints(
    val current_user_url: String = "https://api.github.com/user",
    val current_user_authorizations_html_url: String = "https://github.com/settings/connections/applications{/client_id}",
    val authorizations_url: String = "https://api.github.com/authorizations",
    val code_search_url: String = "https://api.github.com/search/code?q={query}{&page,per_page,sort,order}",
    val commit_search_url: String = "https://api.github.com/search/commits?q={query}{&page,per_page,sort,order}",
    val emails_url: String = "https://api.github.com/user/emails",
    val emojis_url: String = "https://api.github.com/emojis",
    val events_url: String = "https://api.github.com/events",
    val feeds_url: String = "https://api.github.com/feeds",
    val followers_url: String = "https://api.github.com/user/followers",
    val following_url: String = "https://api.github.com/user/following{/target}",
    val gists_url: String = "https://api.github.com/gists{/gist_id}",
    val hub_url: String = "https://api.github.com/hub",
    val issue_search_url: String = "https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}",
    val issues_url: String = "https://api.github.com/issues",
    val keys_url: String = "https://api.github.com/user/keys",
    val notifications_url: String = "https://api.github.com/notifications",
    val organization_repositories_url: String = "https://api.github.com/orgs/{org}/repos{?type,page,per_page,sort}",
    val organization_url: String = "https://api.github.com/orgs/{org}",
    val public_gists_url: String = "https://api.github.com/gists/public",
    val rate_limit_url: String = "https://api.github.com/rate_limit",
    val repository_url: String = "https://api.github.com/repos/{owner}/{repo}",
    val repository_search_url: String = "https://api.github.com/search/repositories?q={query}{&page,per_page,sort,order}",
    val current_user_repositories_url: String = "https://api.github.com/user/repos{?type,page,per_page,sort}",
    val starred_url: String = "https://api.github.com/user/starred{/owner}{/repo}",
    val starred_gists_url: String = "https://api.github.com/gists/starred",
    val team_url: String = "https://api.github.com/teams",
    val user_url: String = "https://api.github.com/users/{user}",
    val user_organizations_url: String = "https://api.github.com/user/orgs",
    val user_repositories_url: String = "https://api.github.com/users/{user}/repos{?type,page,per_page,sort}",
    val user_search_url: String = "https://api.github.com/search/users?q={query}{&page,per_page,sort,order}"
)