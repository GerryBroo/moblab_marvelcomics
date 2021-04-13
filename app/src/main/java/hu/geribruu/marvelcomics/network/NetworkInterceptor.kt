package hu.geribruu.marvelcomics.network


import hu.geribruu.marvelcomics.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val ts = System.currentTimeMillis().toString()
        val apikey = BuildConfig.PUBLIC_API_KEY
        val hashInput = "$ts${BuildConfig.PRIVATE_API_KEY}${BuildConfig.PUBLIC_API_KEY}"

        val httpUrl = originalRequest.url.newBuilder()
                .addQueryParameter(TS, ts)
                .addQueryParameter(API_KEY, apikey)
                .addQueryParameter(HASH, hashInput.md5()).build()

        val builder = originalRequest.newBuilder().url(httpUrl)
        val newRequest = builder.build()

        return chain.proceed(newRequest)
    }

    companion object {
        private val TS = "ts"
        private val API_KEY = "apikey"
        private val HASH = "hash"
    }
}