package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlinx.coroutines.coroutineScope

suspend fun loadContributorsConcurrent(service: GitHubService, req: RequestData): List<User> = coroutineScope {
    TODO()
}