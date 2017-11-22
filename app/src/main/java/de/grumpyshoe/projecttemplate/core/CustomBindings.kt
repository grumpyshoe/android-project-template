package de.grumpyshoe.projecttemplate.core

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View

/**
 * Created by thomas on 16.11.17.
 */
object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setImageUrl(view: View, visibility: Boolean) {
        if (visibility) {
            view.visibility = View.VISIBLE
        }
        else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("android:onRefreshListener")
    fun setOnRefreshListener(view: SwipeRefreshLayout, onRefreshListener: SwipeRefreshLayout.OnRefreshListener){
        view.setOnRefreshListener(onRefreshListener)
    }

    @JvmStatic
    @BindingAdapter("android:setRefreshing")
    fun setRefreshing(view: SwipeRefreshLayout, refreshing: Boolean){
        view.isRefreshing = refreshing
    }
}