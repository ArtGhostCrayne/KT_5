import java.time.LocalDate

object WallService {
     var posts = emptyArray<Post>()
    var lastID = 0;

    fun add(post: Post): Post {
        posts += post
        lastID +=1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var res = false;
        for ((index, post1) in posts.withIndex()) {
            println(post1)

            if (post1.id == post.id) {
                println(index)
                posts[index] = post.copy(text = "изменено", friends_only = false, owner_id = 100, from_id = 100)
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
    var owner_id: Int = 2,
    var from_id: Int = 3,
    val created_by: Int = 4,
    val date: Int = 0,
    var text: String = " - ",
    var friends_only: Boolean = true,
    val likes: Likes
) {

}

class Likes(
    val count: Int = 0,
    val user_like: Boolean = false,
    val can_like: Boolean = true,
    val can_publish: Boolean = true
)


fun main() {

}