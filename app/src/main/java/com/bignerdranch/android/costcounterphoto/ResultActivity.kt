package com.bignerdranch.android.costcounterphoto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val price = intent.getIntExtra("price", 0)

        resultTextView.text = "Оплатить = $price рублей"
    }
}
