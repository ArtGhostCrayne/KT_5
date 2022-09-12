import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {


    @Test
    fun add() {
        val post = Post(id = WallService.lastID + 1, likes = Likes())
        WallService.add(post)
        assertTrue(WallService.lastID > 0)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExists() {
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        val post = Post(2, likes = Likes())
        assertTrue(WallService.update(post))
    }

    @Test
    fun updateNotExists() {
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        WallService.add(Post(id = WallService.lastID + 1, likes = Likes()))
        val post = Post(4, likes = Likes())
        assertFalse(WallService.update(post))
    }
}