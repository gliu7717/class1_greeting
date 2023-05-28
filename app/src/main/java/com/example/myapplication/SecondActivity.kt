package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val userName = intent.getStringExtra("USER")
        val textView =findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, you will get free access to all the content for this month"
        textView.text = message
    }

    override fun onPostResume() {
        super.onPostResume()
    }
}