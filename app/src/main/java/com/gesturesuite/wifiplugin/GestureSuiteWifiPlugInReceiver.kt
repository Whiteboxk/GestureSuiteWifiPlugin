package com.gesturesuite.wifiplugin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class GestureSuiteWifiPlugInReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        intent?.let {
            if(it.action == context.getString(R.string.wifiIntentAction)){
                WifiHandler.wifi(context, it.getIntExtra(context.getString(R.string.IntentActionExtra), -1))
            }
        }
    }
}