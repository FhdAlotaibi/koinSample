package com.koinsample.di

import com.google.gson.GsonBuilder
import com.koinsample.BuildConfig
import com.koinsample.di.DatasourceProperties.SERVER_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val netowrkModule = applicationContext {

    bean {
        val builder = GsonBuilder()
        builder.create()
    }

    bean {
        GsonConverterFactory.create(get())
    }

    bean {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        logging
    }

    bean {
        OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.MINUTES)
                .readTimeout(60L, TimeUnit.MINUTES)
                .writeTimeout(60L, TimeUnit.MINUTES)
                .addNetworkInterceptor(get())
                .build()
    }

    bean {
        buildRetrofit(get(), getProperty(SERVER_URL), get())
    }


}


inline fun <reified T> createApi(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}

fun buildRetrofit(okHttpClient: OkHttpClient, url: String, gsonConverterFactory: GsonConverterFactory) {
    Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            .build()
}

object DatasourceProperties {
    const val SERVER_URL = "https://demo8768859.mockable.io/"
}
