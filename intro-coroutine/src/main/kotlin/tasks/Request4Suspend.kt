package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User

suspend fun loadContributorsSuspend(service: GitHubService, req: RequestData): List<User> {
    TODO()
}