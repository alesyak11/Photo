package com.bignerdranch.android.costcounterphoto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text_format_photo: TextView
    private lateinit var text_count_photo: TextView

    private lateinit var rb_small: RadioButton
    private lateinit var rb_medium: RadioButton
    private lateinit var rb_big: RadioButton

    private lateinit var text_count_photo_small: TextView
    private lateinit var text_count_photo_medium: TextView
    private lateinit var text_count_photo_big: TextView

    private lateinit var enter_quantity: EditText
    private lateinit var okButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_format_photo = findViewById(R.id.text_format_photo)
        text_count_photo = findViewById(R.id.text_count_photo)

        rb_small = findViewById(R.id.rb_small)
        rb_medium = findViewById(R.id.rb_medium)
        rb_big = findViewById(R.id.rb_big)

        text_count_photo_small = findViewById(R.id.text_count_photo_small)
        text_count_photo_medium = findViewById(R.id.text_count_photo_medium)
        text_count_photo_big = findViewById(R.id.text_count_photo_big)

        enter_quantity = findViewById(R.id.quantityEditText)
        okButton = findViewById(R.id.okButton)

        okButton.setOnClickListener {
            val selectedSize = when {
                rb_small.isChecked -> "Small"
                rb_medium.isChecked -> "Medium"
                rb_big.isChecked -> "Big"
                else -> ""
            }

            val quantity = enter_quantity.text.toString().toIntOrNull() ?: 0

            val price = calculatePrice(selectedSize, quantity)

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("price", price)
            }
            startActivity(intent)
        }
    }

    private fun calculatePrice(selectedSize: String, quantity: Int): Int {
        return when (selectedSize) {
            "Small" -> quantity * 100
            "Medium" -> quantity * 150
            "Big" -> quantity * 300
            else -> 0
        }
    }
}