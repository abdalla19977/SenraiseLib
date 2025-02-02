package com.github.senraise_printer

import android.content.Context
import android.graphics.Bitmap
import com.github.senraise_printer.service.SenraiseCallback
import com.github.senraise_printer.service.SenraisePrinterException
import com.github.senraise_printer.service.SenraisePrinterManager
import recieptservice.com.recieptservice.PrinterInterface

/**
 * @Author: abdalla atheer
 * @Email: abdallahatheer.us@gmail.com
 * @Date: 8/9/2022
 */
class SenraisePrinterHelper {


    /**
     * senraisePrinter means checking the printer connection status
     */

    /**
     * PrinterInterface for API
     */
    private var senraisePrinterService: PrinterInterface? = null


    private val innerPrinterCallback: SenraiseCallback = object : SenraiseCallback() {
        override fun onConnected(service: PrinterInterface) {
            senraisePrinterService = service
        }

        override fun onDisconnected() {
            senraisePrinterService = null
        }
    }
    companion object {
        const val LEFT_ALIGN = 0
        const val CENTER_ALIGN = 1
        const val RIGHT_ALIGN = 2
    }


    fun init(context: Context) {
        try {
            SenraisePrinterManager.getInstance().bindService(
                context,
                innerPrinterCallback
            )
        } catch (e: SenraisePrinterException) {
            e.printStackTrace()
        }
    }

    fun deInit(context: Context) {
        try {
            SenraisePrinterManager.getInstance().unBindService(
                context,
                innerPrinterCallback
            )
        } catch (e: SenraisePrinterException) {
            e.printStackTrace()
        }
    }

    fun printText(text: String, textSize: Float, isBold: Boolean) {
        senraisePrinterService?.setTextSize(textSize)
        senraisePrinterService?.setTextBold(isBold)
        senraisePrinterService?.printText(text)
    }

    fun printEpson(byteArray: ByteArray) {
        senraisePrinterService?.printEpson(byteArray)
    }

    fun printTable(texts: Array<String>, width: IntArray?, align: IntArray?) {
        senraisePrinterService?.printTableText(texts, width, align)
    }

    fun printBitmap(bitmap: Bitmap) {
        senraisePrinterService?.printBitmap(bitmap)
    }

    fun feedPaper(lines: Int) {
        senraisePrinterService?.nextLine(lines)
    }

    fun setAlign(align: Int) {
        senraisePrinterService?.setAlignment(align)
    }


}