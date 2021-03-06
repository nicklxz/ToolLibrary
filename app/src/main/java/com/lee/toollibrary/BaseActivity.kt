package com.lee.toollibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init()
        setListener()
        business()
    }
    /**
     * @return xml 布局id
     */
    protected abstract fun getLayoutId(): Int


    /**
     * 初始化
     */
    protected abstract fun init()

    /**
     * 设计时间监听
     */
    protected abstract fun setListener()
    protected abstract fun business()
}
