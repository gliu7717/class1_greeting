package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MYTAG", "MainActivity:OnCreate")

        setContentView(R.layout.activity_main)
        val greetingTextview = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.tvName)
        val submitButton = findViewById<Button>(R.id.btSubmit)
        //val offerButton = findViewById<Button>(R.id.btnOffers)
        val offerButton = findViewById<Button>(R.id.btnOffers)
        var enteredName="";
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()
            if(enteredName == "") {
                offerButton.visibility = INVISIBLE
                greetingTextview.text=""
                Toast.makeText(
                    this@MainActivity,
                    "Please Enter Your name",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val message = "Welcome $enteredName"
                greetingTextview.text = message
                inputField.text.clear()
                offerButton.visibility = VISIBLE
            }
        }
        offerButton.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }
}