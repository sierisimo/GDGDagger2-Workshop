api_github = "https://api.github.com"

curl_options = "-i"

zen:
    curl {{curl_options}} {{api_github}}/zen

endpoints:
    curl {{curl_options}} {{api_github}}

user username='octocat':
    curl {{curl_options}} {{api_github}}/users/{{username}}

repos username='octocat':
    curl {{curl_options}} {{api_github}}/users/{{username}}/repos