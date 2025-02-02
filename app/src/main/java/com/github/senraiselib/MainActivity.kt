package com.github.senraiselib

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.senraise_printer.SenraisePrinterHelper
import com.github.senraise_printer.SenraisePrinterHelper.Companion.CENTER_ALIGN

class MainActivity : AppCompatActivity() {
    private val printer = SenraisePrinterHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_print)

        printer.init(this)

        btn.setOnClickListener {
            printer.setAlign(CENTER_ALIGN)
            printer.printText("Hello World", 27f, false)
            printer.feedPaper(5)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        printer.deInit(this)
    }
}