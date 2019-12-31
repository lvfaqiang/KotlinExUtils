package com.fq.library.kotlin.ex.builder

import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow

/**
 * PopupWindowBuilder
 * @desc :
 *
 */
class PopupWindowBuilder {

    private var width = ViewGroup.LayoutParams.WRAP_CONTENT
    private var height = ViewGroup.LayoutParams.WRAP_CONTENT
    private var mOutsideTouchable = true
    private var mTouchable = true


    fun setWidth(width: Int): PopupWindowBuilder {
        this.width = width
        return this
    }

    fun setHeight(height: Int): PopupWindowBuilder {
        this.height = height
        return this
    }

    fun setOutsideTouchable(mOutsideTouchable: Boolean): PopupWindowBuilder {
        this.mOutsideTouchable = mOutsideTouchable
        return this
    }

    fun setTouchable(mTouchable: Boolean): PopupWindowBuilder {
        this.mTouchable = mTouchable
        return this
    }

    fun build(view: View): PopupWindow {
        return buildPopupWindow(view)
    }

    private fun buildPopupWindow(view: View): PopupWindow {
        return PopupWindow().apply {
            contentView = view
            width = width
            height = height
            setBackgroundDrawable(BitmapDrawable())
            isOutsideTouchable = mOutsideTouchable
            isTouchable = mTouchable
            isFocusable = true
        }
    }
}