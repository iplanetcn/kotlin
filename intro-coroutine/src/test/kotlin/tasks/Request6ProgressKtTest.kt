//package tasks
//
//import contributors.MockGithubService
//import contributors.progressResults
//import contributors.testRequestData
//import kotlinx.coroutines.runBlocking
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//class Request6ProgressKtTest {
//    @Test
//    fun testProgress() = runBlocking {
//        val startTime = System.currentTimeMillis()
//        var index = 0
//        loadContributorsProgress(MockGithubService, testRequestData) {
//            users, _ ->
//            val expected = progressResults[index++]
//            val time = System.currentTimeMillis() - startTime
//            assertEquals(expected.users, users, "Wrong intermediate result after $time:")
//        }
//    }
//}