package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var tv: TextView
    private lateinit var btn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
        btn = findViewById(R.id.button)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        btn.setOnClickListener{
            viewModel.setValue()
        }
        viewModel.counter.observe(this, Observer {
            tv.text = it.toString()
        })
    }
}