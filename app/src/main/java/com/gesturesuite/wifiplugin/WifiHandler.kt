package com.gesturesuite.wifiplugin

import android.content.Context
import android.net.wifi.WifiManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

class WifiHandler {
    companion object{
        const val ON = 1
        const val OFF = 2
        const val TOGGLE = 3

        public fun wifi(context: Context, action: Int) {
            val wifiManager = context.applicationContext.getSystemService(AppCompatActivity.WIFI_SERVICE) as WifiManager?
            wifiManager?.let {
                when (action) {
                    ON ->  {
                        wifiManager.isWifiEnabled = true
                        toast(context, R.string.Wifi_on)
                    }
                    OFF ->  {
                        wifiManager.isWifiEnabled = false
                        toast(context, R.string.Wifi_off)
                    }
                    TOGGLE -> {
                        val newEnabledState = !wifiManager.isWifiEnabled
                        wifiManager.isWifiEnabled = newEnabledState
                        toast(context, if (newEnabledState) R.string.Wifi_on else R.string.Wifi_off)
                    }
                }
            }
        }

        fun toast(context: Context, @StringRes stringResId: Int){
            Toast.makeText(context, context.getString(stringResId), Toast.LENGTH_LONG).show()
        }
    }
}