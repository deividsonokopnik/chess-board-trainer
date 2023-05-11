package com.example.chess_board_trainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    val delay: Long = 1000000000000000
    val interval: Long = 5000

    private val timer = object: CountDownTimer(delay, interval) {
        override fun onTick(millisUntilFinished: Long) {
            val textView: TextView = findViewById(R.id.textView3) as TextView
            val rnd1 = (1..8).random()
            val rnd2 = listOf(('A'..'H')).flatten().random()
            textView.text = rnd1.toString()+rnd2.toString()
        }

        override fun onFinish()
        {
            val textView: TextView = findViewById(R.id.textView3) as TextView
            textView.text = R.string.casa_inicial.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton: ToggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        toggleButton.setOnClickListener()
        {
            if(toggleButton.isChecked)
            {
                timer.start()
            }
            else
            {
                val textView: TextView = findViewById(R.id.textView3) as TextView
                textView.text = applicationContext.getString(R.string.casa_inicial)
                timer.cancel()
            }
        }
    }


}