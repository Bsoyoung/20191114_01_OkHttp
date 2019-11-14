package com.example.a20191114_01_okhttp

import android.os.Bundle
import com.example.a20191114_01_okhttp.utils.ServerUtil

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()

        ServerUtil.postRequestLogin(mContext,"cho881020","qlalfqjsgh!",null)
    }

    override fun setupEvents() {
    }

    override fun setValues() {
    }

}
