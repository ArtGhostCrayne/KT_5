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
                    ownerId = 100,
                    createdBy = 2,
                    text = "изменено",
                    friendsOnly = false,
                    comments = Comments(
                        count = 1,
                        canPost = false,
                        groupsCanPost = false,
                        can_close = false,
                        can_open = false
                    ),
                    copyright = Copyright(1, "-", "-", "-"),
                    likes = Likes(count = 1, userLike = false, canLike = true, canPublish = true)
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
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes
) {

}

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
    WallService.add(Post(id = WallService.lastID + 1, comments = Comments(), copyright = Copyright(), likes = Likes()))
    WallService.add(Post(id = WallService.lastID + 1, comments = Comments(), copyright = Copyright(), likes = Likes()))
    val post = WallService.add(
        Post(
            id = WallService.lastID + 1,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes()
        )
    )

    println(WallService.posts[2])
    WallService.update(post)
    println(WallService.posts[2])
}