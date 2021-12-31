package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User

suspend fun loadContributorsProgress(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    TODO()
}
