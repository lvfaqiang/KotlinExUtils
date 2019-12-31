package com.fq.library.kotlin.ex.view

import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.fq.library.kotlin.ex.getDraw

/**
 * View2019-12-30 18:27
 * @desc :
 *
 */

inline fun View.visible() {
    isVisible = true
}

inline fun View.gone() {
    isGone = true
}

inline fun View.invisible() {
    isInvisible = true
}

inline fun View.isShowOrGone(isShow: Boolean) {
    if (isShow) visible() else gone()
}


inline fun View.isShowOrInVisible(isShow: Boolean) {
    if (isShow) visible() else invisible()
}


inline fun View.toggleHide() {
    this.visibility = if (this.visibility == View.VISIBLE) {
        View.INVISIBLE
    } else {
        View.VISIBLE
    }
}

inline fun View.toggleGone() {
    visibility = if (this.visibility == View.VISIBLE) {
        View.GONE
    } else {
        View.VISIBLE
    }
}


/**
 * Set TextView drawable Resource
 */
inline fun TextView.drawable(@DrawableRes res: Int?, @Position position: Int) {
    val drawable = if (res != null) resources.getDraw(res) else {
        null
    }
    drawable?.let {
        drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    }
    when (position) {
        Position.LEFT -> {
            setCompoundDrawables(drawable, null, null, null)
        }
        Position.RIGHT -> {
            setCompoundDrawables(null, null, drawable, null)
        }
        Position.TOP -> {
            setCompoundDrawables(null, drawable, null, null)
        }
        Position.BOTTOM -> {
            setCompoundDrawables(null, null, null, drawable)
        }
    }
}

@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class Position {
    companion object {
        const val LEFT = 0
        const val TOP = 1
        const val RIGHT = 2
        const val BOTTOM = 3
    }
}
