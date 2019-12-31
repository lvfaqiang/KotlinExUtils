package com.fq.kotlin.exutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.fq.library.kotlin.ex.view.gone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTv.text = "${mTv.isVisible}"
        mTv.setOnClickListener {
            it.gone()
        }
    }
}
