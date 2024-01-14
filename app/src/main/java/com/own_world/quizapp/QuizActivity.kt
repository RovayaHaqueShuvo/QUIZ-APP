package com.own_world.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.own_world.quizapp.databinding.ActivityQuizBinding
import kotlinx.coroutines.newSingleThreadContext

class QuizActivity : AppCompatActivity() {
    private var score = 0
    private var count = 0
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list: ArrayList<QustionModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        list = ArrayList<QustionModel>()

        list.add(
            QustionModel(
                "Who get the prime minister chair in Bangladesh",
                "SHEKH MUJIB",
                "KHALEDA JIYA",
                "TAJUDDIN AHMED",
                "SHEKH HASINA",
                "SHEKH HASINA"
            )
        )
        list.add(
            QustionModel(
                "Which of the following is NOT an anti-virus software ?",
                "Avast",
                "Linux",
                "Norton",
                "Kaspersky",
                "Linux"
            )
        )
        list.add(
            QustionModel(
                "In the context of digital computer, which of the following pairs of digits is referred to as binary code ?",
                "3 and 4",
                "0 and 1",
                "2 and 3",
                "1 and 2",
                "0 and 1"
            )
        )
        list.add(
            QustionModel(
                "Which unit of the computer is considered as the brain of the computer ?",
                "Memory unit",
                "CPU",
                "Input unit",
                "Output unit",
                "CPU"
            )
        )
        list.add(
            QustionModel(
                "What is the full form of PROM ?",
                "Program read-only memory",
                "Primary read-only memory",
                "Programmable read-only memory",
                "Program read-output memory",
                "Programmable read-only memory"
            )
        )

        binding.qustion.setText(list.get(0).Qustion)
        binding.option1.setText(list.get(0).Option)
        binding.option2.setText(list.get(0).Option2)
        binding.option3.setText(list.get(0).Option3)
        binding.option4.setText(list.get(0).Option4)

        binding.option1.setOnClickListener {
            nextdata(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextdata(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextdata(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextdata(binding.option4.text.toString())
        }

    }

    private fun nextdata(i: String) {
        if (count<list.size){
            if(list.get(count).Answer.equals(i)){
                score++

            }
        }

        count++

        if (count>=list.size){
         //   Toast.makeText(this,"Your score is $score",Toast.LENGTH_LONG).show()

            val intent = Intent(this@QuizActivity,ScoreBoardActivity::class.java)
            intent.putExtra("score",score)
            startActivity(intent)
            finish()

        }

        else{
        binding.qustion.setText(list.get(count).Qustion)
        binding.option1.setText(list.get(count).Option)
        binding.option2.setText(list.get(count).Option2)
        binding.option3.setText(list.get(count).Option3)
        binding.option4.setText(list.get(count).Option4)
    }
    }
}