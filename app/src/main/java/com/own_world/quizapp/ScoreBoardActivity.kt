package com.own_world.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.own_world.quizapp.databinding.ActivityScoreBoardBinding

class ScoreBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityScoreBoardBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.score.text = "CONGRATS!!! YOU GOT : ${intent.getIntExtra("score",0) } POINT"

        binding.again.setOnClickListener {
            startActivity(Intent(this@ScoreBoardActivity,QuizActivity::class.java))
            finish()
        }
    }
}