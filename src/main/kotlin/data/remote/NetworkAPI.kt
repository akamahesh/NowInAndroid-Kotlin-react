package data.remote

import data.Video
import kotlinx.coroutines.async
import kotlinx.coroutines.await
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.browser.window

suspend fun fetchVideo(id: Int): Video =
    window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        .await()
        .json()
        .await()
        .unsafeCast<Video>()

suspend fun fetchVideos(): List<Video> =
    coroutineScope {
        (1..25).map {
            async {
                fetchVideo(it)
            }
        }.awaitAll()
    }
