package com.inqlab.ortalamaapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inqlab.ortalamaapp.databinding.ActivityMain2Binding
import java.io.Console
import kotlin.properties.Delegates

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var  listSize = 0

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        binding.username.text = username

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButton3->{
                    listSize = 3
                    binding.point4.invisible()
                    binding.credit4.invisible()
                    binding.point5.invisible()
                    binding.credit5.invisible()
                }
                R.id.radioButton4->{
                    listSize = 4
                    binding.point4.visible()
                    binding.credit4.visible()
                    binding.point5.invisible()
                    binding.credit5.invisible()
                }
                R.id.radioButton5->{
                    binding.point4.visible()
                    binding.credit4.visible()
                    binding.point5.visible()
                    binding.credit5.visible()
                    listSize = 5
                }
            }
        }

        binding.buttonCalculate.setOnClickListener {

            val creditList = ArrayList<Int>()
            val creditAndPoint = ArrayList<Int>()

            if(listSize==3){
                val point1 = binding.point1.text.toString().toInt()
                val point2 = binding.point2.text.toString().toInt()
                val point3 = binding.point3.text.toString().toInt()

                val credit1 =binding.credit1.text.toString().toInt()
                val credit2 =binding.credit2.text.toString().toInt()
                val credit3 =binding.credit3.text.toString().toInt()

                creditList.add(credit1)
                creditList.add(credit2)
                creditList.add(credit3)

                creditAndPoint.add(point1*credit1)
                creditAndPoint.add(point2*credit2)
                creditAndPoint.add(point3*credit3)

            }else if (listSize==4){
                val point1 = binding.point1.text.toString().toInt()
                val point2 = binding.point2.text.toString().toInt()
                val point3 = binding.point3.text.toString().toInt()
                val point4 = binding.point4.text.toString().toInt()

                val credit1 =binding.credit1.text.toString().toInt()
                val credit2 =binding.credit2.text.toString().toInt()
                val credit3 =binding.credit3.text.toString().toInt()
                val credit4 =binding.credit4.text.toString().toInt()

                creditList.add(credit1)
                creditList.add(credit2)
                creditList.add(credit3)
                creditList.add(credit4)

                creditAndPoint.add(point1*credit1)
                creditAndPoint.add(point2*credit2)
                creditAndPoint.add(point3*credit3)
                creditAndPoint.add(point4*credit4)
            }else{
                val point1 = binding.point1.text.toString().toInt()
                val point2 = binding.point2.text.toString().toInt()
                val point3 = binding.point3.text.toString().toInt()
                val point4 = binding.point4.text.toString().toInt()
                val point5 = binding.point5.text.toString().toInt()

                val credit1 =binding.credit1.text.toString().toInt()
                val credit2 =binding.credit2.text.toString().toInt()
                val credit3 =binding.credit3.text.toString().toInt()
                val credit4 =binding.credit4.text.toString().toInt()
                val credit5 =binding.credit5.text.toString().toInt()

                creditList.add(credit1)
                creditList.add(credit2)
                creditList.add(credit3)
                creditList.add(credit4)
                creditList.add(credit5)

                creditAndPoint.add(point1*credit1)
                creditAndPoint.add(point2*credit2)
                creditAndPoint.add(point3*credit3)
                creditAndPoint.add(point4*credit4)
                creditAndPoint.add(point5*credit5)

            }

            var creditSum = 0
            for (i in creditList) {
                 creditSum = creditSum + i
            }

            var creditAndPointSum = 0

            for (i in creditAndPoint) {
                creditAndPointSum = creditAndPointSum + i
            }

            val ortalama = creditAndPointSum / creditSum


            if (ortalama>=50) {
                val intent = Intent(this@MainActivity2,MainActivity3::class.java)
                intent.putExtra("condition",true)
                intent.putExtra("ortalama",ortalama)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this@MainActivity2,MainActivity3::class.java)
                intent.putExtra("condition",false)
                intent.putExtra("ortalama",ortalama)
                startActivity(intent)
                finish()
            }

        }
    }
}