package com.example.zd1_sizov

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class activity_two_screen : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var sharedp: SharedPreferences
    lateinit var userName: TextView
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_screen)
        userName = findViewById(R.id.textView2)
        result = findViewById(R.id.filmtext)
        spinner = findViewById(R.id.spin)
        sharedp = getSharedPreferences("Account", MODE_PRIVATE)
        var log = sharedp.getString("My_Login", "None")
        userName.setText(log).toString()

        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Films,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val ch = resourses.getStringArray(R.id.Films)
                result.setText(choose[position]).toString()

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}