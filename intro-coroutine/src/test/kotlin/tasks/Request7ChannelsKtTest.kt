//package tasks
//
//import contributors.MockGithubService
//import contributors.concurrentProgressResults
//import contributors.testRequestData
//import kotlinx.coroutines.runBlocking
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//class Request7ChannelsKtTest {
//    @Test
//    fun testChannels() = runBlocking {
//        val startTime = System.currentTimeMillis()
//        var index = 0
//        loadContributorsChannels(MockGithubService, testRequestData) {
//                users, _ ->
//            val expected = concurrentProgressResults[index++]
//            val time = System.currentTimeMillis() - startTime
//            assertEquals( expected.users, users, "Wrong intermediate result after $time:")
//        }
//    }
//}
