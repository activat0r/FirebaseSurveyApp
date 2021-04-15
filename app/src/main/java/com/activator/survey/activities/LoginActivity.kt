package com.activator.survey.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.activator.survey.R

class LoginActivity : AppCompatActivity() {
    private var email_editText: EditText? = null
    private var token_edittext: EditText? = null
    private var login_button : Button? = null
    private val TAG: String = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email_editText = findViewById<EditText>(R.id.login_email_edittext)
        token_edittext = findViewById<EditText>(R.id.login_password_edittext)
        login_button = findViewById<Button>(R.id.login_button)

        login_button!!.setOnClickListener(View.OnClickListener {
            if (validate()) {
                Log.d(TAG, "onCreate: checking credentials")

            } else {
                Log.d(TAG, "onCreate: displaying error to fill credentials")
            }
        })

    }

    fun credentialsValidation():Boolean{
        var flag :Boolean = false;

//todo

        return flag
    }

    fun validate():Boolean{
        var flag:Boolean = false
        if(email_editText!!.text.toString().trim() != ""){
            Log.d(TAG, "validate: email not empty")
            if(token_edittext!!.text.toString().trim() != ""){
                Log.d(TAG, "validate: password not empty")
                flag = true
            }
            else{
                Log.d(TAG, "validate: password empty")
                flag = false
            }
        }
        else{
            Log.d(TAG, "validate: email empty")
            flag = false
        }

        return flag

    }
}