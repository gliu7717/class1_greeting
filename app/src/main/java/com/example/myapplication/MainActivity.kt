package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MYTAG", "MainActivity:OnCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var enteredName="";
        binding.btSubmit.setOnClickListener{
            enteredName = binding.tvName.text.toString()
            if(enteredName == "") {
                binding.btnOffers.visibility = INVISIBLE
                binding.tvHello.text=""
                Toast.makeText(
                    this@MainActivity,
                    "Please Enter Your name",
                    Toast.LENGTH_LONG
                ).show()
            }
            else {
                val message = "Welcome $enteredName"
                binding.tvHello.text = message
                binding.tvName.text.clear()
                binding.btnOffers.visibility = VISIBLE
            }
        }
        binding.btnOffers.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }
}