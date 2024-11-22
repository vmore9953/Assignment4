package com.example.assignment4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView: TextView
    private var counter = 0
    private var isTextCentered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        myTextView = findViewById(R.id.myTextView)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        // Button 1 - Change Text
        button1.setOnClickListener {
            counter++
            myTextView.text = "Button Clicked $counter times"
        }

        // Button 2 - Change Height
        button2.setOnClickListener {
            val newHeight = if (myTextView.height == 100) 200 else 100
            myTextView.layoutParams.height = newHeight
            myTextView.requestLayout()
        }

        // Button 3 - Center Text
        button3.setOnClickListener {
            val params = myTextView.layoutParams as RelativeLayout.LayoutParams

            if (isTextCentered) {
                // Reset position
                params.removeRule(RelativeLayout.CENTER_IN_PARENT)
                params.addRule(RelativeLayout.CENTER_HORIZONTAL)
                myTextView.layoutParams = params
            } else {
                // Center text on the screen
                params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
                myTextView.layoutParams = params
            }

            isTextCentered = !isTextCentered
        }
    }
}
