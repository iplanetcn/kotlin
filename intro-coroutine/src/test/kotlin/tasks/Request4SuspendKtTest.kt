//package tasks
//
//import contributors.MockGithubService
//import contributors.expectedResults
//import contributors.testRequestData
//import kotlinx.coroutines.runBlocking
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test
//
//class Request4SuspendKtTest {
//    @Test
//    fun testSuspend() = runBlocking {
//        val startTime = System.currentTimeMillis()
//        val result = loadContributorsSuspend(MockGithubService, testRequestData)
//        assertEquals(expectedResults.users, result, "Wrong result for 'loadContributorsSuspend'")
//        val totalTime = System.currentTimeMillis() - startTime
//        assertTrue(
//            totalTime in expectedResults.timeFromStart..(expectedResults.timeFromStart + 500),
//            "The calls run consequently, so the total time should be around 4000 ms: " +
//                    "1000 for repos request plus (1000 + 1200 + 800) = 3000 for sequential contributors requests)"
//        )
//    }
//}