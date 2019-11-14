package com.example.a20191114_01_okhttp

import android.os.Bundle
import com.example.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()

         }

    override fun setupEvents() {

        loginBtn.setOnClickListener {

            var inputId = userIdEdt.text.toString()
            var inputPw = userPwEdt.text.toString()
            ServerUtil.postRequestLogin(mContext,inputId,inputPw,null)

        }

    }

    override fun setValues() {
    }

}
