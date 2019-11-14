package com.example.a20191114_01_okhttp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity :AppCompatActivity() {

    var mContext:Context = this

    abstract fun setupEvents()
    abstract fun setValues()



}