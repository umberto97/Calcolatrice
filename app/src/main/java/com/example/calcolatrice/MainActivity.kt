package com.example.calcolatrice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        somma.setOnClickListener{
            val a=n1.text.toString().toInt()
            val b=n2.text.toString().toInt()
            ris.setText((a+b).toString())
        }
        val h=5
        val n=6
    }
}
