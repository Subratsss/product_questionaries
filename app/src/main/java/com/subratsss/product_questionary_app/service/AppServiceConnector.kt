package com.subratsss.product_questionary_app.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppServiceConnector {
    private var retrofit: Retrofit? = null
    val serviceConnector: Retrofit?
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(NetworkInterceptor())
                    .addInterceptor(interceptor)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(3, TimeUnit.MINUTES)
                    .retryOnConnectionFailure(true)
                    .build()

            if (retrofit == null) {
                val gson = GsonBuilder().setLenient().create()
                retrofit = Retrofit.Builder()
                        .baseUrl(ApiUrl.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .build()
            }
            return this.retrofit
        }
}