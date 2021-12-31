package tasks

import contributors.MockGithubService
import contributors.expectedResults
import contributors.testRequestData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Request3CallbacksKtTest {
    @Test
    fun testDataIsLoaded() {
        loadContributorsCallbacks(MockGithubService, testRequestData) {
            assertEquals(expectedResults.users, it, "Wrong result for 'loadContributorsCallbacks'")
        }
    }
}