package com.example.a20191114_01_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

        signUpBtn.setOnClickListener {

            var inputId = userIdEdt.text.toString()
            var inputPw = userPwEdt.text.toString()
            var inputName = userNameEdt.text.toString()
            var inputPNum = userPhoneEdt.text.toString()

            ServerUtil.putRequestSignUp(mContext,inputId,inputPw,inputName,inputPNum,object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {

                    Log.d("액티비티에서 보는 응답",json.toString())

                    val code = json.getInt("code")

                    runOnUiThread {
                        if(code==200)
                        {
                            Toast.makeText(mContext,"회원가입 성공",Toast.LENGTH_LONG).show()

                        }else
                        {
                            Toast.makeText(mContext,"회원가입 실패",Toast.LENGTH_SHORT).show()
                        } }
                }
            })


            Toast.makeText(mContext,"회원가입 성공!",Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    override fun setValues() {
    }
}
