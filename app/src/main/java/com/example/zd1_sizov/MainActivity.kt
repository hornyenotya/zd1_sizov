package com.example.zd1_sizov

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var sharedp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.et_login)
        password = findViewById(R.id.et_password)
        sharedp = getSharedPreferences("Account", MODE_PRIVATE)
        if (sharedp.contains("My_Login") && sharedp.contains("My_Password")){
            var log = sharedp.getString("My_Login", "None")
            var pass = sharedp.getString("My_Password", "None")
            login.setText(log)
            password.setText(pass)
        }
    }
    fun input(view: android.view.View) {
        if (!sharedp.contains("My_Login") && !sharedp.contains("My_Password")) {
            if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                var editing = sharedp.edit()
                editing.putString("My_Login", login.text.toString())
                editing.putString("My_Password", password.text.toString())
                editing.apply()
                var i = Intent(this, activity_two_screen::class.java)
                startActivity(i)
            } else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Не все поля заполненны!!!")
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }
        }
        else {
            var log = sharedp.getString("My_Login", "None")
            var pass = sharedp.getString("My_password", "None")
            login.setText(log)
            password.setText(pass)
            val intent = Intent(this, activity_two_screen::class.java)
            startActivity(intent)
        }
    }
}