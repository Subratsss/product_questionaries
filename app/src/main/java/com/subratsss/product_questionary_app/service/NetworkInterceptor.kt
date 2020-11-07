package com.subratsss.product_questionary_app.service

import com.subratsss.product_questionary_app.utils.ApplicationClass
import com.subratsss.product_questionary_app.utils.AppUtils
import com.subratsss.product_questionary_app.utils.NetworkException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!AppUtils.verifyAvailableNetwork(ApplicationClass.getContext())){
            throw NetworkException()
        }else{
            return  chain.proceed(chain.request())
        }
    }
}