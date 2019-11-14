package com.example.a20191114_01_okhttp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

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
            ServerUtil.postRequestLogin(mContext,inputId,inputPw,object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {

                    runOnUiThread {
                        Log.d("액티비티에서 보는 응답",json.toString())

                        var code = json.getInt("code")

                        if(code==400)
                        {
                            var message = json.getString("message")
                            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                        }else if(code == 200){
                            Toast.makeText(mContext,"로그인 성공",Toast.LENGTH_SHORT).show()
                        }
                    }
                    }

            })

        }

    }

    override fun setValues() {
    }

}
