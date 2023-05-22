package com.example.chess_board_trainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.widget.TextView
import android.widget.ToggleButton
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    val delay: Long = 1000000000000000
    val interval: Long = 6000

    private val timer = object: CountDownTimer(delay, interval) {
        override fun onTick(millisUntilFinished: Long) {
            val textView: TextView = findViewById(R.id.textView3) as TextView
            val rnd1 = listOf(('A'..'H')).flatten().random()
            val rnd2 = (1..8).random()
            textView.text = getString(R.string.casa, rnd1.toString(), rnd2.toString())


            var mediaPlayer = MediaPlayer.create(baseContext, R.raw.sa)
            if(rnd1.toString()=="B") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sb) }
            if(rnd1.toString()=="C") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sc) }
            if(rnd1.toString()=="D") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sd) }
            if(rnd1.toString()=="E") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.se) }
            if(rnd1.toString()=="F") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sf) }
            if(rnd1.toString()=="G") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sg) }
            if(rnd1.toString()=="H") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.sh) }

            mediaPlayer.start()
            Thread.sleep(800)

            mediaPlayer = MediaPlayer.create(baseContext, R.raw.s1)
            if(rnd2.toString()=="2") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s2) }
            if(rnd2.toString()=="3") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s3) }
            if(rnd2.toString()=="4") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s4) }
            if(rnd2.toString()=="5") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s5) }
            if(rnd2.toString()=="6") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s6) }
            if(rnd2.toString()=="7") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s7) }
            if(rnd2.toString()=="8") { mediaPlayer = MediaPlayer.create(baseContext, R.raw.s8) }

            mediaPlayer.start()
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

        val switch1:SwitchCompat =  findViewById<SwitchCompat>(R.id.switch1)
        switch1.setOnCheckedChangeListener { _, isChecked ->
            val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
            if (isChecked) {
                imageView.visibility= View.VISIBLE
            } else {
                imageView.visibility= View.INVISIBLE
            }
        }

        val switch2:SwitchCompat =  findViewById<SwitchCompat>(R.id.switch2)
        switch2.setOnCheckedChangeListener { _, isChecked ->
            val imageView:ImageView = findViewById<ImageView>(R.id.imageView)
            if(!isChecked)
            {
                imageView.setImageResource(R.drawable.tab1)
            } else {
                imageView.setImageResource(R.drawable.tab2)
            }
        }
    }

    override fun onInit(status: Int) {
        TODO("Not yet implemented")
    }


}