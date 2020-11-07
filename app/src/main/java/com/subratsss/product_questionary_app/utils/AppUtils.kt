package com.subratsss.product_questionary_app.utils

import android.content.Context
import android.net.ConnectivityManager

class AppUtils {
companion object{
    fun verifyAvailableNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager?.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
        return true
    }
}

}