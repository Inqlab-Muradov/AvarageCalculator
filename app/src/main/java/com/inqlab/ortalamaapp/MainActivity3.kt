package com.inqlab.ortalamaapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inqlab.ortalamaapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
//
        val condition = intent.getBooleanExtra("condition",false)
        val ortalama = intent.getIntExtra("ortalama",15)

        if (condition) {
            binding.resultText.text = ortalama.toString()
            binding.resultImage.setImageResource(R.drawable.winner)
            binding.annotation.text = "You  pass the exam"
        }else{
            binding.resultText.text = ortalama.toString()
            binding.resultImage.setImageResource(R.drawable.loser)
            binding.annotation.text = "You dont pass the exam"

        }
    }
}