object WallService {
    var posts = emptyArray<Post>()
    var lastID = 0;

    fun add(post: Post): Post {
        posts += post
        lastID += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var res = false;
        for ((index, post1) in posts.withIndex()) {

            if (post1.id == post.id) {
                lastID += 1

                posts[index] = post.copy(
                    id = lastID,
                    ownerId = post1.ownerId,
                    date = post1.date
                )
                res = true
            }
        }
        return res
    }

    fun clear() {
        posts = emptyArray()
    }
}

data class Post(
    val id: Int = 1,
    val ownerId: Int = 2,
    val fromId: Int = 3,
    val createdBy: Int = 4,
    val date: Long = System.currentTimeMillis() / 1000,
    val text: String = " - ",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = true,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes,
    val repost: Repost? = null,
    val view: View? = null,
    val postType: String = "",
    val postSource: Postsource? = null,
    val geo: Geo? = null,
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut? = null,
    val postponed_id: Int = 0,
    val attachments: Array<Attachment> = emptyArray()
)

data class Repost(val count: Int = 0, val userReposted: Boolean = false)

data class View(val count: Int = 0)

class Postsource()

data class Geo(val type: String = "", val coordinates: String = "")

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 100,
    val canPublishFreeCopy: Boolean = false,
    val editMode: String = "All"
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val can_close: Boolean = true,
    val can_open: Boolean = true
)

data class Copyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)

data class Likes(
    val count: Int = 0,
    val userLike: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)


abstract class Attachment(val type: String)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Long = System.currentTimeMillis() / 1000,
    val noSearch: Boolean = false,
    val isHQ: Boolean = false
)

data class Photo(
    val id: Int,
    val ownerId: Int,
    val albumId: Int,
    val text: String,
    val url: String,
    val userId: Int,
    val date: Long = System.currentTimeMillis() / 1000,
    val sizes: Array<Images> = emptyArray(),
    val width: Int,
    val height: Int
)

data class Album(
    val id: Int,
    val ownerId: Int,
    val thumb: Photo,
    val title: String,
    val description: String,
    val userId: Int,
    val created: Long = System.currentTimeMillis() / 1000,
    val updated: Long = System.currentTimeMillis() / 1000,
    val size: Int = 0
)

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    var image: Photo? = null,
    var product: Product? = null,
    var button: Button? = null,
    val previewPage: String,
    val previewUrl: String
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val description: String,
    val title: String,
    val duration: Int,
    var image: Array<VideoImage> = emptyArray(),
    val date: Long = System.currentTimeMillis() / 1000,
    val addingDate: Long = System.currentTimeMillis() / 1000,
    val views: Int = 0,
    val local_views: Int = 0,
    val comments: Int = 0,
    val player: String
)

data class VideoImage(val height: Int, val width: Int, val url: String, val withPadding: Boolean = true)
data class Images(val type: String, val height: Int, val width: Int, val url: String)
data class Product(val price: Price)
data class Price(val amount : Int, val currency: Currency, val text: String)
data class Currency(val id: Int, val name: String)
data class Button(val action: Action, val title: String)
data class Action(val url: String, val title: String)

data class AudioAttachment(val audio: Audio) : Attachment("Audio")
data class VideoAttachment(val video: Video) : Attachment("Video")
data class PhotoAttachment(val photo: Photo) : Attachment("Photo")
data class LinkAttachment(val link: Link) : Attachment("Link")
data class AlbumAttachment(val album: Album) : Attachment("Album")


fun main() {

}