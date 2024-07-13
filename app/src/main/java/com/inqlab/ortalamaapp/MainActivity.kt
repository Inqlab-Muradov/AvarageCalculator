package com.inqlab.ortalamaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inqlab.ortalamaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {

            if(binding.textEmailAddress.text.toString().isNotEmpty() && binding.TextPassword.text.toString().isNotEmpty()) {
                val intent = Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("username",binding.textEmailAddress.text.toString())
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Enter the username and password please",Toast.LENGTH_SHORT).show()
            }

        }

    }
}