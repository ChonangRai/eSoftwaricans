package com.example.esoftwaricans

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var etUname : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUname = findViewById(R.id.etUname)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        etUname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                if (etUname.text.toString().length >= 4) {
                    btnLogin.isEnabled = true
                } else {
                    btnLogin.isEnabled = false
                    etUname.setError("Username must be 4 charaters long.")
                }
            }
        })
        etPassword.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
            if (etPassword.text.toString().length >= 8){
                btnLogin.isEnabled = true
            }else{
                btnLogin.isEnabled = false
                etPassword.setError("Password must be 8 characters long.")
            }
            }
        })
    }

    fun loginFunction(view: View) {

        if (etUname.text.toString().toLowerCase() == "softwarica" && etPassword.text.toString() == "coventry"){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "User credentials do not match.", Toast.LENGTH_SHORT).show()
        }
    }
}
