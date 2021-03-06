package msa.domain.actionstate

import msa.domain.core.Action
import msa.domain.core.State
import msa.domain.entities.Post
import msa.domain.entities.PostComment
import msa.domain.entities.User

/**
 * Created by Abhi Muktheeswarar.
 */

sealed class PostAction : Action {

    object LoadPostsAction : PostAction()

    object RefreshPostsAction : PostAction()

    object LoadingPostsAction : PostAction()

    data class PostsLoadedAction(val posts: List<Pair<Post, User>>) : PostAction()

    data class ErrorLoadingPostsAction(val exception: Exception) : PostAction()

    //-------------

    data class LoadPostDetailAction(val postId: Int, val userId: Int) : PostAction()

    data class PostDetailLoadedAction(val post: Post, val comments: List<PostComment>, val user: User) : PostAction()

}

data class PostListState(
    val loading: Boolean = true,
    val refreshing: Boolean = false,
    val posts: List<Pair<Post, User>>? = null,
    val exception: Exception? = null
) : State


data class PostDetailState(
    val loading: Boolean = true,
    val refreshing: Boolean = false,
    val postId: Int? = null,
    val userId: Int? = null,
    val post: Post? = null,
    val comments: List<PostComment>? = null,
    val user: User? = null,
    val exception: Exception? = null
) : State