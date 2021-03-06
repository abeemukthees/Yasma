package msa.yasma.post.list

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.TypedEpoxyController
import msa.domain.actionstate.PostListState
import msa.domain.core.Action
import msa.yasma.common.items.LoadingItemModel_
import msa.yasma.common.items.SimpleItemModel
import msa.yasma.common.items.simpleItem

/**
 * Created by Abhi Muktheeswarar.
 */

class PostListController(private val itemActionListener: (action: Action) -> Unit) :
    TypedEpoxyController<PostListState>() {

    @AutoModel
    lateinit var loadingItemModel: LoadingItemModel_

    fun setState(state: PostListState) {
        setData(state)
    }

    override fun buildModels(state: PostListState) {

        loadingItemModel.addIf(state.loading, this)

        state.posts?.forEach { (post, user) ->

            simpleItem {

                id(post.id)
                itemId(post.id)
                userId(user.id)
                itemType(SimpleItemModel.SimpleItemType.POST)
                title(post.title)
                name(user.name)
                body(post.body)
                itemActionListener(itemActionListener)
            }
        }

    }
}

