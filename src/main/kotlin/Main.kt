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
    val postponed_id: Int = 0
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


fun main() {
    val post = WallService.add(
        Post(
            id = WallService.lastID + 1,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes()
        )
    )

    println(post)
}